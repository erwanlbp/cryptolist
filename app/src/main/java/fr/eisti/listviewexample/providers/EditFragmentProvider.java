package fr.eisti.listviewexample.providers;

import java.util.List;

import fr.eisti.listviewexample.Cryptomonnaie;
import fr.eisti.listviewexample.Datas;
import fr.eisti.listviewexample.fragments.EditFragment;

/**
 * Created by ErwanLBP on 27/10/17.
 */

public class EditFragmentProvider {

    // Views
    private EditFragment fragment;

    // Datas
    private List<Cryptomonnaie> cryptomonnaies;
    private String oldName;

    public EditFragmentProvider(EditFragment fragment) {
        this.fragment = fragment;
        this.cryptomonnaies = Datas.getInstance().getCryptomonnaies();
    }

    public Cryptomonnaie findDetails(String name) {
        for (Cryptomonnaie c : cryptomonnaies) {
            if (c.getName().equals(name)) {
                this.oldName = name;
                return c;
            }
        }
        return null;
    }

    public boolean edit(String name, String description) {
        if (oldName == null) {
            return false;
        }

        for (Cryptomonnaie c : this.cryptomonnaies) {
            if (c.getName().equals(oldName)) {
                c.setName(name);
                c.setDescription(description);
                fragment.getActivity().finish();
                return true;
            }
        }
        return false;
    }
}
