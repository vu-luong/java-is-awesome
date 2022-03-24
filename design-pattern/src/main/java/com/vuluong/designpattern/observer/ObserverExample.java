package com.vuluong.designpattern.observer;

public class ObserverExample {

    public static void main(String[] args) {
        NewsAgency observable = new NewsAgency();
        NewsChannel observer = new NewsChannel();

        observable.addObserver(observer);
        observable.setNews("news");
    }
}
