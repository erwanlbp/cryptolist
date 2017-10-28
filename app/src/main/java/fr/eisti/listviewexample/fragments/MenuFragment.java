package fr.eisti.listviewexample.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import fr.eisti.listviewexample.datas.Cryptomonnaie;
import fr.eisti.listviewexample.R;
import fr.eisti.listviewexample.providers.MenuFragmentProvider;

public class MenuFragment extends Fragment implements View.OnClickListener {

    private MenuFragmentProvider provider;
    private TextView cryptoNameTv;
    private TextView cryptoDescriptionTv;

    private String cryptoName;
    private Cryptomonnaie cryptomonnaie;

    public MenuFragment() {
        this.provider = new MenuFragmentProvider(this);
    }

    public static MenuFragment newInstance(String param1) {
        MenuFragment fragment = new MenuFragment();

        Bundle args = new Bundle();
        args.putString(Cryptomonnaie.NAME, param1);
        fragment.setArguments(args);

        return fragment;
    }

    public void edit(View view) {
        this.provider.edit(cryptoName);
    }

    public void delete(View view) {
        boolean success = this.provider.delete(cryptomonnaie);
        if (!success) {
            Toast.makeText(getActivity(), "Failed deleting this", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        if (getArguments() == null) {
            return view;
        }

        this.cryptoName = getArguments().getString(Cryptomonnaie.NAME);

        // TODO TO CHANGE
        this.cryptomonnaie = this.provider.findDetails(this.cryptoName);
        if (this.cryptomonnaie == null) {
            view.setVisibility(View.INVISIBLE);
            return view;
        }

        cryptoNameTv = (TextView) view.findViewById(R.id.cryptoName_tv);
        cryptoNameTv.setText(cryptomonnaie.getName());

        cryptoDescriptionTv = (TextView) view.findViewById(R.id.cryptoDescription_tv);
        cryptoDescriptionTv.setText(cryptomonnaie.getDescription());

        view.findViewById(R.id.delete_button).setOnClickListener(this);
        view.findViewById(R.id.edit_button).setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.edit_button:
                edit(view);
                Log.i("#####", "MenuFragment Edit");
                break;
            case R.id.delete_button:
                Log.i("#####", "MenuFragment Delete");
                delete(view);
                break;
            default:
                Toast.makeText(getActivity(), "Onclick ID not recognized", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
