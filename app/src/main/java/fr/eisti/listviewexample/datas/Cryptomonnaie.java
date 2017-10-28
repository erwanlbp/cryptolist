package fr.eisti.listviewexample.datas;

/**
 * Created by ErwanLBP on 18/10/17.
 */

public class Cryptomonnaie {

    public final static String NAME = "CRYPTO_NAME";

    private long ID;
    private String name;
    private String description;

    public Cryptomonnaie() {}

    public Cryptomonnaie(long ID, String name, String description) {
        this.ID = ID;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return name;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }
}
