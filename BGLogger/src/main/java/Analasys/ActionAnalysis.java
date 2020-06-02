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
public class ActionAnalysis extends Analysis {

    List<Event> Attempts = new ArrayList<>();
    List<Event> Succeses = new ArrayList<>();
    List<Event> Fails = new ArrayList<>();

    public ActionAnalysis(String _initiator) {
        super(_initiator);
    }

    @Override
    void run() {

    }

    @Listener(event = MyEventType.SPELL_CAST_START)
    public void castAttempt(Event evt) {
        if (evt.getInitiator().equals(this.initiator)) {
            Attempts.add(evt);
        }
    }

    @Listener(event = MyEventType.SPELL_AURA_APPLIED)
    public void SuccesAura(Event evt) {
        if (evt.getInitiator().equals(this.initiator)) {
            Succeses.add(evt);
        }
    }

    @Listener(event = MyEventType.SPELL_CAST_SUCCESS)
    public void SuccesCast(Event evt) {
        if (evt.getInitiator().equals(this.initiator)) {
            Succeses.add(evt);
        }
    }

    @Listener(event = MyEventType.SPELL_CAST_FAILED)
    public void FailedCast(Event evt) {
        if (evt.getInitiator().equals(this.initiator)) {
            Fails.add(evt);
        }
    }
}
