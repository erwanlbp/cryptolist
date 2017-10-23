package fr.eisti.listviewexample;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class CryptoActivity extends AppCompatActivity {

    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypto);
    }

    public void clickAddEntry(View view) {
        Intent intent = new Intent(this, NewActivity.class);
        startActivity(intent);
    }
}
