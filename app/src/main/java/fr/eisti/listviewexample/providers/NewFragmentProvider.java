package fr.eisti.listviewexample.providers;

import java.util.List;

import fr.eisti.listviewexample.datas.Cryptomonnaie;
import fr.eisti.listviewexample.datas.Datas;
import fr.eisti.listviewexample.fragments.NewFragment;

/**
 * Created by ErwanLBP on 27/10/17.
 */

public class NewFragmentProvider {

    // Views
    private NewFragment fragment;

    // Datas
    private List<Cryptomonnaie> cryptomonnaies;

    public NewFragmentProvider(NewFragment fragment) {
        this.fragment = fragment;
        this.cryptomonnaies = Datas.getInstance().getCryptomonnaies();
    }

    public void addNewCryptomonnaie(String name, String description) {
        Cryptomonnaie cryptomonnaie = new Cryptomonnaie(-1,name, description);
        cryptomonnaies.add(cryptomonnaie);
        fragment.getActivity().finish();
    }
}
