package com.example.demo.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class ForestryApplicationWatcherEvent extends ApplicationEvent {

    private int eventType;
    private String message;

    public ForestryApplicationWatcherEvent(Object source) {
        super(source);
    }
}
