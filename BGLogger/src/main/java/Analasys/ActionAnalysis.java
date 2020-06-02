/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analasys;

import EventHandler.Event;
import EventHandler.MyEventType;
import Listeners.Listener;

/**
 *
 * @author Martin
 */
public class ActionAnalysis extends Analysis
{

    @Override
    public void addData(String _data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Runnable run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Listener
    public void lyt(Event evt){
        System.out.println(evt.getEventType());
    }
    @Listener(event=MyEventType.DUEL)
    public void lyt2(){
        
    }
    
}
