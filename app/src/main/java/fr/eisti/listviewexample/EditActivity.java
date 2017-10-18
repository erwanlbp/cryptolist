package fr.eisti.listviewexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent intent = getIntent();
        String cryptoName = intent.getStringExtra("cryptoName");

        TextView textview = (TextView) findViewById(R.id.cryptoName_tv);
        textview.setText(cryptoName);

        TextView textView = (TextView) findViewById(R.id.cryptoDescription_tv);
        // Get Description
    }
}
