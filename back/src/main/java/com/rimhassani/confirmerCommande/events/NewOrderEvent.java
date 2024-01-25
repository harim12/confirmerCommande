package com.rimhassani.confirmerCommande.events;

import org.springframework.context.ApplicationEvent;

public class NewOrderEvent extends ApplicationEvent {

    public NewOrderEvent(Object source){
        super(source);
    }
}
