package com.example.gnitgnosil.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {

    // ------------ViewPager---------------
    private List<View> views = new ArrayList<>();
    private ViewPager viewPager;
    private LinearLayout llChat, llContacts;
    private ImageView ivChat, ivContacts, ivCurrent;
    private TextView tvChat, tvContacts,tvCurrent;


    //------------RecyclerView----conversations----

    private List<Contacts> converList = new ArrayList<>();
    private RecyclerView converRecyclerView;
    private TryQuickAdapter converQuickAdapter;

    //------------RecyclerView----contacts---------
    private List<Contacts> contactsList = new ArrayList<>();
    private RecyclerView ctacRecyclerView;
    private TryQuickAdapter ctacQuickAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_main);

        initView();
        initData();

    }

    private void initView() {
        //-----------------------------------ViewPager--------------------------------

        viewPager = findViewById(R.id.viewPager);

        llChat = findViewById(R.id.llChat);
        llContacts = findViewById(R.id.llContacts);

        llChat.setOnClickListener(this);
        llContacts.setOnClickListener(this);

        ivChat =  findViewById(R.id.ivChat);
        ivContacts =  findViewById(R.id.ivContacts);

        tvChat = findViewById(R.id.tvChat);
        tvContacts =  findViewById(R.id.tvContacts);

        ivChat.setSelected(true);
        tvChat.setSelected(true);
        ivCurrent = ivChat;
        tvCurrent = tvChat;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                changeTab(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

                }
        });
    }

    private void initData() {

        initContactsData();
        initConversation();

        LayoutInflater mInflater = LayoutInflater.from(this);
        View tab01 = mInflater.inflate(R.layout.chat_conversations,null);
        View tab02 = mInflater.inflate(R.layout.chat_contacts, null);

        //------------------Recycler-------convertions---------------------
        converRecyclerView = tab01.findViewById(R.id.conversation_recycler_view);
        LinearLayoutManager converLayoutManager = new LinearLayoutManager(this);
        converRecyclerView.setLayoutManager(converLayoutManager);

        converQuickAdapter = new TryQuickAdapter(R.layout.contacts_item,converList);
        converRecyclerView.setAdapter(converQuickAdapter);

        converQuickAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(ChatActivity.this, "onItemClick" + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ChatActivity.this,MsgActivity.class);
                startActivity(intent);
            }
        });

        //------------------Recycler-------contacts---------------------
        ctacRecyclerView = tab02.findViewById(R.id.contacts_recycler_view);
        LinearLayoutManager ctacLayoutManager = new LinearLayoutManager(this);
        ctacRecyclerView.setLayoutManager(ctacLayoutManager);
        ctacQuickAdapter = new TryQuickAdapter(R.layout.contacts_item,contactsList);
        ctacRecyclerView.setAdapter(ctacQuickAdapter);

        views.add(tab01);
        views.add(tab02);

        MyPagerAdapter adapter = new MyPagerAdapter(this,views);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {

        changeTab(v.getId());
    }

    private void changeTab(int id) {
        ivCurrent.setSelected(false);
        tvCurrent.setSelected(false);
        switch (id) {
            case R.id.llChat:
                viewPager.setCurrentItem(0);
            case 0:
                ivChat.setSelected(true);
                ivCurrent = ivChat;
                tvChat.setSelected(true);
                tvCurrent = tvChat;
                break;



            case R.id.llContacts:
                viewPager.setCurrentItem(2);
            case 1:
                ivContacts.setSelected(true);
                ivCurrent = ivContacts;
                tvContacts.setSelected(true);
                tvCurrent = tvContacts;
                break;

            default:
                break;
        }
    }


    private void initContactsData(){

        Contacts contacts1 = new Contacts("克里斯蒂亚洛 罗纳尔多","C罗，今夏加盟尤文，有点溜");
        Contacts contacts2 = new Contacts("莱特纳希尔 李","Gnitgnosil，李松庭倒着念，牛逼");
        Contacts contacts3 = new Contacts("慢猪积奇","人称慢猪,很好的球员");
        Contacts contacts4 = new Contacts("基耶利尼","人很不错，还是个硕士");
        contactsList.add(contacts1);
        contactsList.add(contacts2);
        contactsList.add(contacts3);
        contactsList.add(contacts4);
    }

    private void initConversation(){

        Contacts conversation1 = new Contacts("克里斯蒂亚洛 罗纳尔多","C罗，今夏加盟尤文，有点溜");
        Contacts conversation2 = new Contacts("莱特纳希尔 李","Gnitgnosil，李松庭倒着念，牛逼");
        Contacts conversation4 = new Contacts("基耶利尼","人很不错，还是个硕士");
        converList.add(conversation1);
        converList.add(conversation2);
        converList.add(conversation4);
    }
}
