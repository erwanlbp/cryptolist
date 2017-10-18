package fr.eisti.listviewexample;

/**
 * Created by ErwanLBP on 18/10/17.
 */

public class Cryptomonnaie {

    private String name;
    private String description;

    public Cryptomonnaie(String name, String description) {
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
}
