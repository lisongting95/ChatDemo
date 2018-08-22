package com.example.gnitgnosil.myapplication;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class TryQuickAdapter extends BaseQuickAdapter <Contacts,BaseViewHolder>{

    public TryQuickAdapter(int layoutResId, List data){
        super(layoutResId,data);
    }

    @Override
    protected void convert(BaseViewHolder helper , Contacts item){
        helper.setText(R.id.contacts_name_text, item.getName());
        helper.setText(R.id.contacts_info_text, item.getInfo());
//        helper.setImageResource(R.id.icon, item.getImageResource());

    }



}
