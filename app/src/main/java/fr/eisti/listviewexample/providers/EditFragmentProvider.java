package fr.eisti.listviewexample.providers;

import java.util.List;

import fr.eisti.listviewexample.datas.Cryptomonnaie;
import fr.eisti.listviewexample.datas.Datas;
import fr.eisti.listviewexample.datas.MySQLHelper;
import fr.eisti.listviewexample.datas.dao.CryptomonnaieDAO;
import fr.eisti.listviewexample.fragments.EditFragment;

/**
 * Created by ErwanLBP on 27/10/17.
 */

public class EditFragmentProvider {

    // Views
    private EditFragment fragment;

    // Datas
    private Cryptomonnaie monnaie;

    public EditFragmentProvider(EditFragment fragment) {
        this.fragment = fragment;
    }

    public Cryptomonnaie findDetails(int id) {
        MySQLHelper helper = new MySQLHelper(fragment.getActivity());
        monnaie = CryptomonnaieDAO.find(helper, id);
        return monnaie;
    }

    public boolean edit(String name, String description) {
        if (monnaie == null) {
            return false;
        }

        monnaie.setName(name);
        monnaie.setDescription(description);

        MySQLHelper helper = new MySQLHelper(fragment.getActivity());
        boolean updated = CryptomonnaieDAO.update(helper, monnaie);
        if (updated) {
            fragment.getActivity().finish();
        }

        return updated;
    }
}
