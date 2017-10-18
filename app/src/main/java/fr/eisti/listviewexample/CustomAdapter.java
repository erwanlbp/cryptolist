package fr.eisti.listviewexample;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ErwanLBP on 18/10/17.
 */

public class CustomAdapter extends ArrayAdapter<String> {

    private final String[] items;
    private final Context context;
    private final Integer[] thumbnails;

    public CustomAdapter(Context context, int layoutToInflate, String[] items, Integer[] thumbnails) {
        super(context, R.layout.cryptolist, items);
        this.context = context;
        this.items = items;
        this.thumbnails = thumbnails;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View row = inflater.inflate(R.layout.cryptolist, null);
        TextView label = (TextView) row.findViewById(R.id.tvLabel);
//        ImageView icon = (ImageView) row.findViewById(R.id.ivIcon);
        label.setText(this.items[position]);
//        icon.setImageResource(this.thumbnails[position]);
        return row;
    }
}
