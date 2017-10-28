package fr.eisti.listviewexample.providers;

import fr.eisti.listviewexample.datas.Cryptomonnaie;
import fr.eisti.listviewexample.datas.MySQLHelper;
import fr.eisti.listviewexample.datas.dao.CryptomonnaieDAO;
import fr.eisti.listviewexample.fragments.NewFragment;

/**
 * Created by ErwanLBP on 27/10/17.
 */

public class NewFragmentProvider {

    // Views
    private NewFragment fragment;

    public NewFragmentProvider(NewFragment fragment) {
        this.fragment = fragment;
    }

    public void addNewCryptomonnaie(String name, String description) {
        Cryptomonnaie cryptomonnaie = new Cryptomonnaie(-1, name, description);

        MySQLHelper helper = new MySQLHelper(fragment.getActivity());
        CryptomonnaieDAO.insert(helper, cryptomonnaie);

        fragment.getActivity().finish();
    }
}
