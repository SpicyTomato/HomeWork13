package com.spicytomato.helloworld.recycler;

public class Mess {


    private String content;
    private String way;


    Mess(String content,String way){
        this.content = content;
        this.way = way;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String getWay() {
        return way;
    }
}
