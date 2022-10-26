package com.example.contactsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactsRVAdapter extends RecyclerView.Adapter<ContactsRVAdapter.ViewHolder>{
    private Context context;
    private ArrayList<ContactsModal> contactsModalsArrayList;

    public ContactsRVAdapter(Context context, ArrayList<ContactsModal> contactsModalsArrayList) {
        this.context = context;
        this.contactsModalsArrayList = contactsModalsArrayList;
    }

    public void  filterList(ArrayList<ContactsModal> filterlist){
            contactsModalsArrayList = filterlist;
            notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.id.contacts_rv_item,parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull ContactsRVAdapter.ViewHolder holder, int position) {
        ContactsModal modal = contactsModalsArrayList.get(position);
        holder.contactTV.setText(modal.getUserName());
        ColorGenerator generator = ColorGenerator.MATERIAL;
        int color = generator.getRamdomColor();

        TextDrawable drawable2 = TextDrawable.builder().beginConfig()
                .width(100)
                .height(100)
                .endConfig()
                .buildRound(modal.getUserName().substring(0,1),color);

        holder.contactIV.setImageDrawable(drawable2);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ContactDetailActivity.class);
                i.putExtra("name",modal.getUserName());
                i.putExtra("contact",modal.getContactNumber());
                context.startActivity(i);
            }
        });

    }


    @Override
    public int getItemCount() {
        return contactsModalsArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView contactIV;
        private TextView contactTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            contactIV = itemView.findViewById(R.id.idIVContact);
            contactTV = itemView.findViewById(R.id.idTVContactName);
        }
    }



}
