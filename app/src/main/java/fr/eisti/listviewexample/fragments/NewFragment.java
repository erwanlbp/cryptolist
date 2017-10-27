package fr.eisti.listviewexample.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import fr.eisti.listviewexample.R;
import fr.eisti.listviewexample.providers.NewFragmentProvider;

/**
 * Created by ErwanLBP on 25/10/17.
 */

public class NewFragment extends Fragment implements View.OnClickListener {

    private NewFragmentProvider provider;

    private EditText textCryptoName;
    private EditText textCryptoDescription;

    public NewFragment() {
        this.provider = new NewFragmentProvider(this);
    }

    public static NewFragment newInstance() {
        NewFragment fragment = new NewFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new, container, false);

        textCryptoName = (EditText) view.findViewById(R.id.cryptoName_et);
        textCryptoDescription = (EditText) view.findViewById(R.id.cryptoDescription_et);

        view.findViewById(R.id.add_button).setOnClickListener(this);

        return view;
    }

    public void addNew(View view) {
        String name = textCryptoName.getText().toString();
        String des = textCryptoDescription.getText().toString();
        this.provider.addNewCryptomonnaie(name, des);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_button:
                addNew(view);
                Log.i("#####", "NewFragment New");
                break;
            default:
                Toast.makeText(getActivity(), "Onclick ID not recognized", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
