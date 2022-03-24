package com.vuluong.designpattern.observer;

import java.util.Observable;

public class ObservableNewsAgency extends Observable {
    private String news;

    public void setNews(String news) {
        this.news = news;
        setChanged();
        notifyObservers(news);
    }
}
