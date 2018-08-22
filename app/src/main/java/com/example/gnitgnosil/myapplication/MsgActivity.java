package com.example.gnitgnosil.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MsgActivity extends AppCompatActivity {

    private List<Msg> msgList = new ArrayList<>();
    private EditText msgTextInput;
    private Button msgBtnSend;
    private RecyclerView msgRecyclerView;
    private MsgAdapter msgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_chat);

        Msg msg1 = new Msg("慢猪积奇","yo, bro, what sup.",Msg.TYPE_RECEIVED);
        Msg msg2 = new Msg("挤椰里泥","yeah, long time no see, man -- how are you doing.",Msg.TYPE_SENT);
        Msg msg3 = new Msg("慢猪积奇","well, spending time with girls..you know that.",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        msgList.add(msg2);
        msgList.add(msg3);

        msgTextInput = findViewById(R.id.msg_text_input);
        msgBtnSend = findViewById(R.id.msg_btn_send);
        msgRecyclerView = findViewById(R.id.msg_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        msgAdapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(msgAdapter);

        msgBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = msgTextInput.getText().toString();
                if(!content.equals("")){
                    Msg msg = new Msg("挤椰里泥",content,Msg.TYPE_SENT);
                    msgList.add(msg);
                    msgAdapter.notifyItemInserted(msgList.size()-1);
                    msgRecyclerView.scrollToPosition(msgList.size()-1);
                    msgTextInput.setText("");
                }
            }
        });
    }
}
