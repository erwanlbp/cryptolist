package fr.eisti.listviewexample.providers;

import android.content.Intent;
import android.content.res.Configuration;

import java.util.List;

import fr.eisti.listviewexample.Cryptomonnaie;
import fr.eisti.listviewexample.Datas;
import fr.eisti.listviewexample.activities.EditActivity;
import fr.eisti.listviewexample.fragments.MenuFragment;

/**
 * Created by ErwanLBP on 27/10/17.
 */

public class MenuFragmentProvider {
    // Views
    private MenuFragment fragment;

    // Datas
    private List<Cryptomonnaie> cryptomonnaies;

    public MenuFragmentProvider(MenuFragment fragment) {
        this.fragment = fragment;
        this.cryptomonnaies = Datas.getInstance().getCryptomonnaies();
    }

    public void edit(String name) {
        Intent intent = new Intent(fragment.getActivity(), EditActivity.class);
        intent.putExtra(Cryptomonnaie.NAME, name);
        // TODO Pas sur
        fragment.startActivity(intent);
        if (fragment.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            fragment.getActivity().finish();
        }
    }

    public boolean delete(Cryptomonnaie cryptomonnaie) {
        boolean success = this.cryptomonnaies.remove(cryptomonnaie);
        if (success && fragment.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            fragment.getActivity().finish();
        }
        return success;
    }

    public Cryptomonnaie findDetails(String name) {
        for (Cryptomonnaie c : cryptomonnaies) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }
}
