package fr.eisti.listviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
    }

    public void addNew(View view) {
        EditText textCryptoName  = (EditText) findViewById(R.id.newCryptoName_tv);
        EditText textCryptoDescription = (EditText) findViewById(R.id.newCryptoDescription_tv);

        String name = textCryptoName.getText().toString();
        String des = textCryptoDescription.getText().toString();

        Cryptomonnaie cryptomonnaie = new Cryptomonnaie(name, des);

        Datas.getInstance().add(cryptomonnaie);
        
        finish();
    }

}
