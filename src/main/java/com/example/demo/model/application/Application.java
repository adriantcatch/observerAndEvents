package com.example.demo.model.application;

import com.example.demo.observer.application.ApplicationObserver;
import com.example.demo.observer.ObservableSubject;
import com.example.demo.observer.Observer;
import com.example.demo.utility.SpringContext;

import java.util.List;

public class Application implements ObservableSubject {

    private int id;
    private int appsCode;
    private List<ApplicationObserver> observerList;

    public Application(){
        this.registerObservers();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAppsCode() {
        return appsCode;
    }

    public void setAppsCode(int appsCode) {
        this.appsCode = appsCode;
        updateObservers();
    }

    @Override
    public void registerObservers() {

        this.observerList = SpringContext.getBeans(ApplicationObserver.class);

        for(Observer observer : observerList){
            observer.registerObservableSubject(this);
        }
    }

    @Override
    public void updateObservers() {
        for(Observer observer : observerList){
            observer.update();
        }
    }
}
