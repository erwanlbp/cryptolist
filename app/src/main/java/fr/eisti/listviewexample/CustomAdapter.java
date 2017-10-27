package fr.eisti.listviewexample;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ErwanLBP on 18/10/17.
 */

public class CustomAdapter extends ArrayAdapter<Cryptomonnaie> {

    private Context context;
    private List<Cryptomonnaie> cryptomonnaies;

    public CustomAdapter(Context context, int layoutToInflate, List<Cryptomonnaie> cryptomonnaies) {
        super(context, R.layout.fragment_cryptomonnaies, cryptomonnaies);
        this.context = context;
        this.cryptomonnaies = cryptomonnaies;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View row = inflater.inflate(R.layout.fragment_cryptomonnaies, null);

        TextView id = (TextView) row.findViewById(R.id.idCrypto);
        id.setText(String.valueOf(position));

        Log.i("#####", "getView " + this.cryptomonnaies.get(position).getName());

        TextView label = (TextView) row.findViewById(R.id.content);
        label.setText(this.cryptomonnaies.get(position).getName());

//        ImageView icon = (ImageView) row.findViewById(R.id.ivIcon);
//        icon.setImageResource(this.thumbnails[position]);

        return row;
    }

    public void swapItems(List<Cryptomonnaie> cryptomonnaies) {
        this.cryptomonnaies = cryptomonnaies;
        notifyDataSetChanged();
    }
}
