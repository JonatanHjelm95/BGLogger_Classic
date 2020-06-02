/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analasys;

import EventHandler.*;
import Listeners.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Martin
 */
public class ActionAnalysis extends Analysis
{


    List<Event> AgressiveActions = new ArrayList<>();
    List<Event> BuffActions = new ArrayList<>();
    List<Event> SupportActions = new ArrayList<>();
    List<Event> ConsumableActions = new ArrayList<>();
    List<Event> UnknownActions = new ArrayList<>();

    public ActionAnalysis(String _initiator) {
        super(_initiator);
    }

    @Override
    void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Listener
    public void AnyEvent(Event evt) {
        if (evt.getInitiator().equals(this.initiator)) {
            switch (evt.getEventType()) {
                case ANY :
                default:
                    UnknownActions.add(evt);
            }

        }
    }

}
