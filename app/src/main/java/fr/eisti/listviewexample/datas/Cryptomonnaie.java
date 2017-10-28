package fr.eisti.listviewexample.datas;

/**
 * Created by ErwanLBP on 18/10/17.
 */

public class Cryptomonnaie {

    public final static String INTENT_ID = "CRYPTO_ID";

    private int ID;
    private String name;
    private String description;

    public Cryptomonnaie() {
    }

    public Cryptomonnaie(int ID, String name, String description) {
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
