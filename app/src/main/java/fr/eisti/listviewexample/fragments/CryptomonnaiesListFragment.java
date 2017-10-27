package fr.eisti.listviewexample.fragments;

import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import fr.eisti.listviewexample.CustomAdapter;
import fr.eisti.listviewexample.R;
import fr.eisti.listviewexample.providers.CryptoListFragmentProvider;

public class CryptomonnaiesListFragment extends ListFragment {

    private CustomAdapter adapter;
    private CryptoListFragmentProvider provider;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CryptomonnaiesListFragment() {
        this.provider = new CryptoListFragmentProvider(this);
    }

    public static CryptomonnaiesListFragment newInstance() {
        CryptomonnaiesListFragment fragment = new CryptomonnaiesListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cryptomonnaies_list, container, false);

        Log.i("#####", "onCreateView");

        adapter = new CustomAdapter(getActivity(), R.layout.fragment_cryptomonnaies, provider.buildList());
        setListAdapter(adapter);

        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        provider.itemClicked(position);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("#####", "onResume");
        adapter.swapItems(provider.buildList());
    }
}
