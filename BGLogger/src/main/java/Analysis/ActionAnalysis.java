/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analysis;

import EventHandler.*;
import GrafikObjects.Plot;
import Listeners.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    void setup() {
        Attempts.stream().sorted(timestamp);
        Succeses.stream().sorted(timestamp);
        Fails.stream().sorted(timestamp);
    }

    @Override
    void run() {
        double succesPercent = Succeses.size() / Attempts.size();
        double succesFailScore = Succeses.size() / Fails.size();
        Long t0 = Attempts.get(0).getTime().getTime();
        List<Double> X = new ArrayList<>();
        new ArrayList<>();
        Stream<Event> _AStream = Attempts.stream();
        _AStream.map(s -> s.getTime().getTime() - t0)
                .map(Double::valueOf)
                .collect(Collectors.groupingBy(k -> k, Collectors.counting()));
        ).toArray(double[][]::new);
        Plot plot = new Plot
        
        

    
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
            Attempts.add(evt);
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
