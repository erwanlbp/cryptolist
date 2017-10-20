package fr.eisti.listviewexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EditActivity extends AppCompatActivity {

    private Cryptomonnaie cryptomonnaie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent intent = getIntent();
        String cryptoName = intent.getStringExtra(Cryptomonnaie.NAME);
        this.cryptomonnaie = Datas.getInstance().get(cryptoName);

        EditText textCryptoName  = (EditText) findViewById(R.id.editCryptoName_tv);
        textCryptoName.setText(cryptoName);

        EditText textCryptoDescription = (EditText) findViewById(R.id.editCryptoDescription_tv);
        textCryptoDescription.setText(cryptomonnaie.getDescription());
    }

    public void save(View view) {
        EditText textCryptoName  = (EditText) findViewById(R.id.editCryptoName_tv);
        EditText textCryptoDescription = (EditText) findViewById(R.id.editCryptoDescription_tv);

        this.cryptomonnaie.setName(textCryptoName.getText().toString());
        this.cryptomonnaie.setDescription(textCryptoDescription.getText().toString());

        finish();
    }
}
