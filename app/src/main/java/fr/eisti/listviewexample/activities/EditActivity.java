package fr.eisti.listviewexample.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import fr.eisti.listviewexample.datas.Cryptomonnaie;
import fr.eisti.listviewexample.R;
import fr.eisti.listviewexample.fragments.EditFragment;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        int id = getIntent().getIntExtra(Cryptomonnaie.INTENT_ID, -1);

        getFragmentManager()
                .beginTransaction()
                .add(R.id.crypto_edit, EditFragment.newInstance(id))
                .commit();
    }
}
