package fr.eisti.listviewexample.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import fr.eisti.listviewexample.Cryptomonnaie;
import fr.eisti.listviewexample.R;
import fr.eisti.listviewexample.fragments.MenuFragment;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        String name = getIntent().getStringExtra(Cryptomonnaie.NAME);

        getFragmentManager()
                .beginTransaction()
                .add(R.id.crypto_menu, MenuFragment.newInstance(name))
                .commit();
    }
}
