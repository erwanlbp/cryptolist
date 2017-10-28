package fr.eisti.listviewexample.providers;

import android.content.Intent;
import android.content.res.Configuration;

import fr.eisti.listviewexample.datas.Cryptomonnaie;
import fr.eisti.listviewexample.activities.EditActivity;
import fr.eisti.listviewexample.datas.MySQLHelper;
import fr.eisti.listviewexample.datas.dao.CryptomonnaieDAO;
import fr.eisti.listviewexample.fragments.MenuFragment;

/**
 * Created by ErwanLBP on 27/10/17.
 */

public class MenuFragmentProvider {
    // Views
    private MenuFragment fragment;

    public MenuFragmentProvider(MenuFragment fragment) {
        this.fragment = fragment;
    }

    public void edit(int id) {
        Intent intent = new Intent(fragment.getActivity(), EditActivity.class);
        intent.putExtra(Cryptomonnaie.INTENT_ID, id);
        // TODO Pas sur
        fragment.startActivity(intent);
        if (fragment.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            fragment.getActivity().finish();
        }
    }

    public boolean delete(Cryptomonnaie cryptomonnaie) {
        MySQLHelper helper = new MySQLHelper(fragment.getActivity());
        boolean success = CryptomonnaieDAO.delete(helper, cryptomonnaie);
        if (success && fragment.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            fragment.getActivity().finish();
        }
        return success;
    }

    public Cryptomonnaie findDetails(long id) {
        MySQLHelper helper = new MySQLHelper(fragment.getActivity());
        return CryptomonnaieDAO.find(helper, id);
    }
}
