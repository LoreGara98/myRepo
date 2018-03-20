package com.example.lorealerick.a611.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.lorealerick.a611.Adapters.AdptBdList;
import com.example.lorealerick.a611.Interfaces.ListenerHome;
import com.example.lorealerick.a611.MainActivity;
import com.example.lorealerick.a611.Models.ModelBirthday;
import com.example.lorealerick.a611.R;
import com.example.lorealerick.a611.Utils.RecyclerDecoration;

import java.util.ArrayList;

/**
 * Created by LoreAleRick on 18/03/2018.
 */

public class FragHome extends Fragment implements SearchView.OnQueryTextListener{

    private Activity a;
    private ListenerHome listenerHome;
    private ArrayList <ModelBirthday> birthdays;
    private AdptBdList adptBdList;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        a = (Activity) context;
        listenerHome = (MainActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.frag_home,container,false);

        FloatingActionButton fabAdd = view.findViewById(R.id.fab_add);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view,"Ciao stronxo",Snackbar.LENGTH_SHORT).show();
                listenerHome.addBdPressed();
            }
        });

        birthdays = new ArrayList<>();
        birthdays.add(new ModelBirthday("Lore","06/11"));
        birthdays.add(new ModelBirthday("Ale","06/06"));
        birthdays.add(new ModelBirthday("Ricky","25/05"));
        birthdays.add(new ModelBirthday("Lore","06/11"));
        birthdays.add(new ModelBirthday("Lore","06/11"));
        birthdays.add(new ModelBirthday("Ale","06/06"));
        birthdays.add(new ModelBirthday("Ricky","25/05"));
        birthdays.add(new ModelBirthday("Lore","06/11"));

        adptBdList = new AdptBdList(a,birthdays,listenerHome);
        RecyclerView bdList = view.findViewById(R.id.bdList);
        bdList.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        bdList.addItemDecoration(new RecyclerDecoration(a,R.dimen.recyclerSpacing));
        bdList.setAdapter(adptBdList);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.toolbar_menu, menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);

        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        newText = newText.toLowerCase();
        ArrayList <ModelBirthday> aus = new ArrayList<>();
        for(ModelBirthday m : birthdays){

            String name = m.getNome().toLowerCase();
            if(name.contains(newText)){

                aus.add(m);
            }
        }

        adptBdList.setFilter(aus);

        return true;
    }
}
