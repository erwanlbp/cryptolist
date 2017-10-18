package fr.eisti.listviewexample;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;

public class CryptoListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypto_list);

        List<Cryptomonnaie> monnaies = Datas.getInstance().getCryptomonnaies();
        String[] names = new String[monnaies.size()];
        for (int i = 0; i < monnaies.size(); i++) {
            names[i] = monnaies.get(i).getName();
        }

        CustomAdapter adapter = new CustomAdapter(this, R.layout.cryptolist, names, null);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra(Cryptomonnaie.NAME, Datas.getInstance().getCryptomonnaies().get(position).getName());
        startActivity(intent);
    }

    public void clickAddEntry(View view) {
        finish();
    }
}
