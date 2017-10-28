package fr.eisti.listviewexample.providers;

import android.content.Intent;
import android.content.res.Configuration;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import fr.eisti.listviewexample.datas.Cryptomonnaie;
import fr.eisti.listviewexample.datas.Datas;
import fr.eisti.listviewexample.R;
import fr.eisti.listviewexample.activities.MenuActivity;
import fr.eisti.listviewexample.activities.NewActivity;
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
        this.cryptomonnaies = buildList();
    }

    // FOR : What to do when I click on an item of the list
    public void itemClicked(int positionClicked) {
        if (positionClicked == 0) {
            Intent intent = new Intent(fragment.getActivity(), NewActivity.class);
            fragment.startActivity(intent);
        } else {
            String cryptoName = this.cryptomonnaies.get(positionClicked).getName();
            if (fragment.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                fragment.getActivity().getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.crypto_detail, MenuFragment.newInstance(cryptoName))
                        .commit();
            } else {
                Intent intent = new Intent(fragment.getActivity(), MenuActivity.class);
                intent.putExtra(Cryptomonnaie.NAME, cryptoName);
                fragment.startActivity(intent);
            }
        }
    }

    public List<Cryptomonnaie> buildList() {
        List<Cryptomonnaie> monnaies = new ArrayList<>();
        monnaies.add(new Cryptomonnaie(-1,"Add ...", ""));
        monnaies.addAll(Datas.getInstance().getCryptomonnaies());
        Log.i("#####", "buildList() -> " + monnaies.size());
        return monnaies;
    }
}
