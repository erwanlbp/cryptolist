package fr.eisti.listviewexample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ErwanLBP on 18/10/17.
 */

public class Datas {

    private List<Cryptomonnaie> cryptomonnaies;

    private static Datas instance;

    private Datas(){
        this.cryptomonnaies = new ArrayList<>();
        this.cryptomonnaies.add(new Cryptomonnaie("Bitcoin", "La plus chere"));
    }

    public static Datas getInstance() {
        if(instance==null)
            instance = new Datas();
        return instance;
    }

    public Cryptomonnaie get(String name) {
        for (Cryptomonnaie c : this.cryptomonnaies) {
            if (c.getName().equals(name))
                return c;
        }
        return null;
    }

    public void add(Cryptomonnaie monnaie) {
        if(monnaie == null) return;
        this.cryptomonnaies.add(monnaie);
    }

    public void delete(Cryptomonnaie monnaie) {
        this.cryptomonnaies.remove(monnaie);
    }

    public void edit(Cryptomonnaie monnaie) {
        int index = this.cryptomonnaies.indexOf(monnaie);
        Cryptomonnaie toEdit = this.cryptomonnaies.get(index);
        if(toEdit == null)
            return;
        toEdit.setName(monnaie.getName());
        toEdit.setDescription(monnaie.getDescription());
    }

    public List<Cryptomonnaie> getCryptomonnaies() {
        return this.cryptomonnaies;
    }

}
