package fr.eisti.listviewexample.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import fr.eisti.listviewexample.Cryptomonnaie;
import fr.eisti.listviewexample.R;
import fr.eisti.listviewexample.providers.EditFragmentProvider;

/**
 * Created by ErwanLBP on 25/10/17.
 */

public class EditFragment extends Fragment implements View.OnClickListener {

    private EditFragmentProvider provider;

    private EditText textCryptoName;
    private EditText textCryptoDescription;


    public EditFragment() {
        this.provider = new EditFragmentProvider(this);
    }

    public static EditFragment newInstance(String name) {
        EditFragment fragment = new EditFragment();

        Bundle args = new Bundle();
        args.putString(Cryptomonnaie.NAME, name);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit, container, false);

        if (getArguments() == null) {
            return view;
        }

        String name = getArguments().getString(Cryptomonnaie.NAME);
        if (name == null || name.isEmpty()) {
            return view;
        }

        Cryptomonnaie monnaie = this.provider.findDetails(name);
        if (monnaie == null) {
            return view;
        }

        textCryptoName = (EditText) view.findViewById(R.id.cryptoName_et);
        textCryptoName.setText(monnaie.getName());
        textCryptoDescription = (EditText) view.findViewById(R.id.cryptoDescription_et);
        textCryptoDescription.setText(monnaie.getDescription());

        view.findViewById(R.id.edit_edit_button).setOnClickListener(this);

        return view;
    }

    public void edit(View view) {
        String name = textCryptoName.getText().toString();
        String des = textCryptoDescription.getText().toString();

        boolean success = this.provider.edit(name, des);
        if (!success) {
            Toast.makeText(getActivity(), "Failed editing", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.edit_edit_button:
                edit(view);
                Log.i("#####", "EditFragment edit");
                break;
            default:
                Toast.makeText(getActivity(), "Onclick ID not recognized", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
