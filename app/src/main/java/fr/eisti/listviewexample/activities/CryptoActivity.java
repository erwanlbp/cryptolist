package fr.eisti.listviewexample.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import fr.eisti.listviewexample.R;
import fr.eisti.listviewexample.fragments.CryptomonnaiesListFragment;
import fr.eisti.listviewexample.fragments.MenuFragment;

public class CryptoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypto);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.crypto_list, CryptomonnaiesListFragment.newInstance())
                .commit();

        // TODO Pas sur maybe provider
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.crypto_detail, MenuFragment.newInstance(""))
                    .commit();
        }
    }
}
