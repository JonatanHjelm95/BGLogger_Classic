/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import EventHandler.Event;
import EventHandler.EventHandler;
import EventHandler.Input;
import javafx.event.EventType;

/**
 *
 * @author Martin
 */
public class DuelListener implements ListenerInterface{
    
    public DuelListener(){
        
    }

    @Override
    public void invoke(Event _event) {
        System.out.println("reee " +_event);
        Event _event2 = new Input();
        EventHandler.getInstance().addEvent(_event2);
        
    }
    
}
