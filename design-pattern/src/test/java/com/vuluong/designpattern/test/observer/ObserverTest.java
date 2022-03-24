package com.vuluong.designpattern.test.observer;

import com.vuluong.designpattern.observer.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ObserverTest {

    @Test
    public void test() {
        NewsAgency observable = new NewsAgency();
        NewsChannel observer = new NewsChannel();

        observable.addObserver(observer);
        observable.setNews("news");
        assertEquals(observer.getNews(), "news");
    }

    @Test
    public void observerTest() {
        ObservableNewsAgency observable = new ObservableNewsAgency();
        ObserverNewsChannel observer = new ObserverNewsChannel();

        observable.addObserver(observer);
        observable.setNews("news");
        assertEquals(observer.getNews(), "news");
    }

    @Test
    public void propertyChangeSupportTest() {
        PCLNewsAgency observable = new PCLNewsAgency();
        PCLNewsChannel observer = new PCLNewsChannel();

        observable.addPropertyChangeListener(observer);
        observable.setNews("news");
        assertEquals(observer.getNews(), "news");
    }
}
