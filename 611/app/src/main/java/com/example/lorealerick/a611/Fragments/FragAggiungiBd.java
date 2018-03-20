package com.example.lorealerick.a611.Fragments;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lorealerick.a611.R;

import java.util.Calendar;

/**
 * Created by LoreAleRick on 18/03/2018.
 */

public class FragAggiungiBd extends Fragment {

    private EditText editData;
    private DatePickerDialog.OnDateSetListener onDateSetListener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.frag_aggiungi_bd,container,false);

        EditText editNome = view.findViewById(R.id.editNome);

        editData = view.findViewById(R.id.editData);
        editData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(

                        getActivity(),
                        onDateSetListener,
                        year,month,day);
                datePickerDialog.show();
            }
        });


        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.MONTH,month);

                String mese = calendar.getDisplayName(Calendar.MONTH,Calendar.LONG,getResources().getConfiguration().locale);

                editData.setText(dayOfMonth+" "+mese+" "+year);
            }
        };

        return view;
    }




    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.add_bd_menu, menu);

        MenuItem menuItem = menu.findItem(R.id.action_save);
        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                Toast.makeText(getActivity(),"Saved",Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        super.onCreateOptionsMenu(menu,inflater);
    }
}
