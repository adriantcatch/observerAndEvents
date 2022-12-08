package com.example.demo.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ForestryApplicationWatcherEventProcessor {

    @EventListener
    void handleForestryApplicationEvent(ForestryApplicationWatcherEvent event){
        System.out.println("Event received by processor...");
    }

}
