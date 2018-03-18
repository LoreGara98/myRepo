package com.example.lorealerick.a611;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;


import com.example.lorealerick.a611.Fragments.FragHome;
import com.example.lorealerick.a611.Interfaces.ListenerHome;

public class MainActivity extends AppCompatActivity implements ListenerHome {

    private Fragment fragments [];
    private String titles [];
    private final int nPages = 1;
    private FragmentManager fragmentManager;
    private TextView toolbarTitle;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setUpViews();
        initializeFragments();

        fragmentManager = getSupportFragmentManager();


        addFragment(0,false);
        setTitle(titles[0]);
    }

    private void setUpViews (){

        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //toolbarTitle = findViewById(R.id.toolbarTitle);
    }

    private void setTitle (String title){

        //toolbarTitle.setText(title);
    }

    private void addFragment (int index, boolean addToStack){

        if(addToStack)
            fragmentManager.beginTransaction().add(R.id.content,fragments[index]).addToBackStack(null).commit();
        else
            fragmentManager.beginTransaction().add(R.id.content,fragments[index]).commit();
    }

    private void replaceFragment (int index, boolean addToStack){

        if(addToStack)
            fragmentManager.beginTransaction().replace(R.id.content,fragments[index]).addToBackStack(null).commit();
        else
            fragmentManager.beginTransaction().replace(R.id.content,fragments[index]).commit();
    }

    private void initializeFragments (){

        fragments = new Fragment[nPages];
        titles = new String[nPages];

        fragments [0] = new FragHome();
        titles [0] = "Home";
    }

    @Override
    public void bdPressed(String nome) {

        //Toast.makeText(this,nome,Toast.LENGTH_SHORT).show();
    }
}
