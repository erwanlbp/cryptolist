package fr.eisti.listviewexample;

import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    private String cryptoName;
   // private Cryptomonnaie cryptomonnaie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        this.cryptoName = intent.getStringExtra("cryptoName");
        //this.cryptomonnaie =

        //TextView textview = (TextView) findViewById(R.id.cryptoName_tv);
        //textview.setText(cryptoName);

        //TextView textView = (TextView) findViewById(R.id.cryptoDescription_tv);


    }

    public void edit(View view) {
        Intent intent = new Intent(this, EditActivity.class);
        intent.putExtra("cryptoName", cryptoName);
        startActivity(intent);
    }
}
