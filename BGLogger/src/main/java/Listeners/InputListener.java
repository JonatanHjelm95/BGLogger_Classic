/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import EventHandler.Duel;
import EventHandler.Event;
import EventHandler.EventHandler;


/**
 *
 * @author Martin
 */
public class InputListener implements ListenerInterface{

    @Override
    public void invoke(Event _event) {
        System.out.println("oooo" +_event.getEventType());
        Event _event2 = new Duel();
        _event2.setData("boop");
        EventHandler.getInstance().addEvent(_event2);
    }

}
