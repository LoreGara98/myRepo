package com.example.lorealerick.a611.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lorealerick.a611.Interfaces.ListenerHome;
import com.example.lorealerick.a611.Interfaces.RecyclerViewListener;
import com.example.lorealerick.a611.Models.ModelBirthday;
import com.example.lorealerick.a611.R;

import java.util.ArrayList;

/**
 * Created by LoreAleRick on 18/03/2018.
 */

public class AdptBdList extends RecyclerView.Adapter <AdptBdList.ViewHolder> {

    public  ArrayList <ModelBirthday> birthdays;
    private Context context;
    ListenerHome listenerHome;

    public AdptBdList (Context context, ArrayList <ModelBirthday> birthdays, ListenerHome listenerHome) {

        this.birthdays = birthdays;
        this.context = context;
        this.listenerHome = listenerHome;
    }

    @Override
    public AdptBdList.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_bd,parent,false);

        return new AdptBdList.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.nome.setText(birthdays.get(position).getNome());
        holder.data.setText(birthdays.get(position).getData());

        holder.setItemClickListener(new RecyclerViewListener() {
            @Override
            public void onItemClick(View v, int position) {

                listenerHome.bdPressed(birthdays.get(position).getNome());
            }
        });
    }

    @Override
    public int getItemCount() {
        return birthdays.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView nome;
        public TextView data;

        RecyclerViewListener recyclerViewListener;

        public ViewHolder(View itemView) {

            super(itemView);

            nome = itemView.findViewById(R.id.nome);
            data = itemView.findViewById(R.id.data);
            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(RecyclerViewListener recyclerViewListener){
            this.recyclerViewListener=recyclerViewListener;
        }

        @Override
        public void onClick(View view) {

            recyclerViewListener.onItemClick(view,getAdapterPosition());
        }
    }

    public void setFilter (ArrayList <ModelBirthday> birthdays){

        this.birthdays = new ArrayList<>();
        this.birthdays.addAll(birthdays);
        notifyDataSetChanged();
    }
}
