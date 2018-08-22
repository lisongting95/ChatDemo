package com.example.gnitgnosil.myapplication;

public class Msg {
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SENT = 1;

    private String name;
    private String content;
    private int type;


    public Msg(String name, String content,int type){
        this.name=name;
        this.content=content;
        this.type=type;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
