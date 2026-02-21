package com.tmehulic.designpatterns.observer.java;

import java.util.Observable;
import java.util.Observer;

public class ObservableExample {

    static class NewsChannel implements Observer {

        private String news;

        @Override
        public void update(Observable o, Object news) {
            System.out.println("News Channel received update: " + news);
            this.news = (String) news;
        }

        public String getNews() {
            return news;
        }
    }

    static class NewsPublisher extends Observable {
        private String news;

        public void setNews(String news) {
            this.news = news;
            setChanged();
            notifyObservers(news);
        }

        public String getNews() {
            return news;
        }
    }
}
