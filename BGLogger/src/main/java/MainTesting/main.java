/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainTesting;

import EventHandler.*;
import Listeners.DuelListener;
import Listeners.InputListener;

/**
 *
 * @author jonab
 */
public class main {
    public static void main(String[] args) {
        EventHandler eh = EventHandler.getInstance();
        eh.addListener(MyEventType.INPUT, new InputListener());
        eh.addListener(MyEventType.DUEL, new DuelListener());
        
        Event evt = new Input();
        
        eh.addEvent(evt);
    }
}
