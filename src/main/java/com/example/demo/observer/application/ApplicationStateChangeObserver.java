package com.example.demo.observer.application;

import com.example.demo.event.ForestryApplicationWatcherEvent;
import com.example.demo.model.application.Application;
import com.example.demo.observer.ObservableSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class ApplicationStateChangeObserver implements ApplicationObserver {

    private Application application;
    private int appsCode;

    private ApplicationEventPublisher applicationEventPublisher;

    private ApplicationStateChangeObserver(@Autowired ApplicationEventPublisher applicationEventPublisher){
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void registerObservableSubject(ObservableSubject observableSubject) {
        this.application = (Application) observableSubject;
        appsCode = application.getAppsCode();
    }

    @Override
    public void update() {

        if(application.getAppsCode() != appsCode){
            System.out.println("Observed change in appsCode! " + application.getAppsCode() + " | " + appsCode);

            applicationEventPublisher.publishEvent(new ForestryApplicationWatcherEvent(application));

        }

    }
}
