package com.example.gnitgnosil.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    private List<Contacts> mContactsList;


    static class ViewHolder extends RecyclerView.ViewHolder{

        LinearLayout contactsLayout;

        TextView contactsName;
        TextView contactsInfo;

        public ViewHolder(View view){
            super(view);
            contactsLayout = view.findViewById(R.id.contacts_item);
            contactsName = view.findViewById(R.id.contacts_name_text);
            contactsInfo = view.findViewById(R.id.contacts_info_text);

        }
    }

    public ContactsAdapter(List<Contacts> contactsList){
        mContactsList = contactsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Contacts contacts = mContactsList.get(position);
        holder.contactsName.setText(contacts.getName());
        holder.contactsInfo.setText(contacts.getInfo());

    }

    @Override
    public int getItemCount(){
        return mContactsList.size();
    }
}
