/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainTesting;

import EventHandler.*;
import Listeners.DuelListener;
import Listeners.InputListener;
import Listeners.ListenerInterface;

/**
 *
 * @author jonab
 */


public class main {
    private static int test = 0;
    public static void main(String[] args) {
        System.out.println("Main Startet");
        EventHandler eh = EventHandler.getInstance();
        eh.addListener(MyEventType.INPUT, new InputListener());
        eh.addListener(MyEventType.DUEL, new DuelListener());
        
        ListenerInterface listener = (Event evt) ->{System.out.println("neeej! et lambda udtryk! "+test); test++;};
        eh.addListener(MyEventType.INPUT, listener);
        Event evt = new Input();
        
        eh.addEvent(evt);
        System.out.println("Event Added");
    }
}
