package fr.eisti.listviewexample.fragments;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import fr.eisti.listviewexample.Cryptomonnaie;
import fr.eisti.listviewexample.CustomAdapter;
import fr.eisti.listviewexample.Datas;
import fr.eisti.listviewexample.R;

public class CryptomonnaiesListFragment extends ListFragment {

    private CustomAdapter adapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CryptomonnaiesListFragment() {
    }

    public static CryptomonnaiesListFragment newInstance() {
        CryptomonnaiesListFragment fragment = new CryptomonnaiesListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cryptomonnaies_list, container, false);

        List<Cryptomonnaie> monnaies = Datas.getInstance().getCryptomonnaies();
        adapter = new CustomAdapter(getActivity(), R.layout.fragment_cryptomonnaies, monnaies);
        setListAdapter(adapter);

        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(getActivity(), "Load " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.swapItems(Datas.getInstance().getCryptomonnaies());
    }
}
