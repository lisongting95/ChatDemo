package com.example.gnitgnosil.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button vpBtn;
    private Button ctBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        vpBtn=findViewById(R.id.go_to_viewpager);
        ctBtn=findViewById(R.id.go_to_chat);

        vpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ChatActivity.class);
                startActivity(intent);
            }
        });

        ctBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MsgActivity.class);
                startActivity(intent);
            }
        });

    }
}
