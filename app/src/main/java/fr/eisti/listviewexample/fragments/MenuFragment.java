package fr.eisti.listviewexample.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fr.eisti.listviewexample.Cryptomonnaie;
import fr.eisti.listviewexample.Datas;
import fr.eisti.listviewexample.EditActivity;
import fr.eisti.listviewexample.R;

public class MenuFragment extends Fragment {

    private String cryptoName;
    private Cryptomonnaie cryptomonnaie;

    public MenuFragment() {
        // Required empty public constructor
    }

    public static MenuFragment newInstance(String param1) {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();

        args.putString(Cryptomonnaie.NAME, param1);
        fragment.setArguments(args);

        return fragment;
    }

    public void edit(View view) {
        Intent intent = new Intent(getActivity(), EditActivity.class);
        intent.putExtra(Cryptomonnaie.NAME, cryptoName);
        startActivity(intent);
    }

    public void delete(View view) {
        Datas.getInstance().delete(cryptomonnaie);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        this.cryptoName = getArguments().getString(Cryptomonnaie.NAME);
        this.cryptomonnaie = Datas.getInstance().get(this.cryptoName);

        TextView cryptoNameTv = (TextView) view.findViewById(R.id.cryptoName_tv);
        cryptoNameTv.setText(cryptoName);

        TextView cryptoDescriptionTv = (TextView) view.findViewById(R.id.cryptoDescription_tv);
        cryptoDescriptionTv.setText(cryptomonnaie.getDescription());

        return view;
    }

}
