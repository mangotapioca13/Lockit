package com.example.lockit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lockit.CharmAdapter;
import com.example.lockit.R;
import com.example.lockit.models.Charm;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class CharmsFragment extends Fragment {

    private Toolbar toolbar;
    private RecyclerView rvCharms;
    private CharmAdapter charmAdapter;
    private List<Charm> charmsList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_charms, container, false);

        // Required for setting action bar title
        getActivity().setTitle("");

        // Notifies host activity that fragment has menu items
        setHasOptionsMenu(true);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle("Charms");
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        // Locate the recyclerView
        rvCharms = (RecyclerView) view.findViewById(R.id.rvCharms);

        // Create the data source
        charmsList = new ArrayList<>();

        // Create the adapter
        charmAdapter = new CharmAdapter(getContext(), charmsList);

        // Set the adapter on the recyclerView
        rvCharms.setAdapter(charmAdapter);

        // Set the layout manager on the recyclerView
        rvCharms.setLayoutManager(new LinearLayoutManager(getContext()));

        queryCharms();
    }

    public void queryCharms() {
        ParseQuery<Charm> charmQuery = new ParseQuery<Charm>(Charm.class);

        // Specify what you want to include by referencing the key
        charmQuery.include(Charm.KEY_USER);

        // Order how the charms are displayed
        charmQuery.addAscendingOrder(Charm.KEY_ORG_NAME);

        charmQuery.findInBackground(new FindCallback<Charm>() {
            @Override
            public void done(List<Charm> charms, ParseException e) {
                if (e != null) {
                    e.printStackTrace();
                    return;
                }

                charmsList.addAll(charms);
                charmAdapter.notifyDataSetChanged();
            }
        });
    }
}