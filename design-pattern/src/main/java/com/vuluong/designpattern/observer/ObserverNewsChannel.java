package com.vuluong.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

public class ObserverNewsChannel implements Observer {

    private String news;

    @Override
    public void update(Observable observable, Object news) {
        this.setNews((String) news);
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }
}
