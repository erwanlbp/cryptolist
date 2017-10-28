package fr.eisti.listviewexample.providers;

import android.content.Intent;
import android.content.res.Configuration;

import java.util.List;

import fr.eisti.listviewexample.R;
import fr.eisti.listviewexample.activities.MenuActivity;
import fr.eisti.listviewexample.activities.NewActivity;
import fr.eisti.listviewexample.datas.Cryptomonnaie;
import fr.eisti.listviewexample.datas.MySQLHelper;
import fr.eisti.listviewexample.datas.dao.CryptomonnaieDAO;
import fr.eisti.listviewexample.fragments.CryptomonnaiesListFragment;
import fr.eisti.listviewexample.fragments.MenuFragment;

/**
 * Created by ErwanLBP on 27/10/17.
 */

public class CryptoListFragmentProvider {

    // Views
    private CryptomonnaiesListFragment fragment;

    // Datas
    private List<Cryptomonnaie> cryptomonnaies;

    public CryptoListFragmentProvider(CryptomonnaiesListFragment fragment) {
        this.fragment = fragment;
    }

    // FOR : What to do when I click on an item of the list
    public void itemClicked(int positionClicked) {
        if (positionClicked == 0) {
            Intent intent = new Intent(fragment.getActivity(), NewActivity.class);
            fragment.startActivity(intent);
        } else {
            int cryptoID = this.cryptomonnaies.get(positionClicked).getID();
            if (fragment.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                fragment.getActivity().getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.crypto_detail, MenuFragment.newInstance(cryptoID))
                        .commit();
            } else {
                Intent intent = new Intent(fragment.getActivity(), MenuActivity.class);
                intent.putExtra(Cryptomonnaie.INTENT_ID, cryptoID);
                fragment.startActivity(intent);
            }
        }
    }

    public List<Cryptomonnaie> buildList() {
        MySQLHelper helper = new MySQLHelper(fragment.getActivity());

        this.cryptomonnaies = CryptomonnaieDAO.findAll(helper);
        this.cryptomonnaies.add(0, new Cryptomonnaie(-1, "Add ...", ""));

        return cryptomonnaies;
    }
}
