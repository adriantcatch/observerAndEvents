package com.example.demo.observer;

public interface Observer {

    void registerObservableSubject(ObservableSubject observableSubject);
    void update();

}
