package fr.eisti.listviewexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    private String cryptoName;
    private Cryptomonnaie cryptomonnaie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        this.cryptoName = intent.getStringExtra("cryptoName");
        this.cryptomonnaie = Datas.getInstance().get(this.cryptoName);

        TextView cryptoNameTv = (TextView) findViewById(R.id.cryptoName_tv);
        cryptoNameTv.setText(cryptoName);

        TextView cryptoDescriptionTv = (TextView) findViewById(R.id.cryptoDescription_tv);
        cryptoDescriptionTv.setText(cryptomonnaie.getDescription());
    }

    public void edit(View view) {
        Intent intent = new Intent(this, EditActivity.class);
        intent.putExtra("cryptoName", cryptoName);
        startActivity(intent);
    }

    public void delete(View view) {
        Datas.getInstance().delete(cryptomonnaie);
    }
}
