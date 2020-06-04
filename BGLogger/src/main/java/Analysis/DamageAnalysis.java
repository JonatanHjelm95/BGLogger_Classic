/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analysis;

import EventHandler.Event;
import EventHandler.MyEventType;
import Listeners.Listener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

/**
 *
 * @author jonab
 */
public class DamageAnalysis extends Analysis {

    List<Event> SpellDamage = new ArrayList<>();
    List<Event> SwingDamage = new ArrayList<>();
    List<Event> RangedDamage = new ArrayList<>();

    public DamageAnalysis(String _initiator, AnalysisHandler _instance) {
        super(_initiator, _instance);
    }



    @Override
    void run() {
       // int swingSum = SwingDamage.stream().mapToInt(Integer::intValue).sum();
      //  int spellSum = SpellDamage.stream().mapToInt(Integer::intValue).sum();
      //  int rangedSum = RangedDamage.stream().mapToInt(Integer::intValue).sum();
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Listener(event = MyEventType.SPELL_DAMAGE)
    public void SpellDamage(Event evt) {
        if (evt.getInitiator().equals(this.initiator)) {
            SpellDamage.add(evt);
        }
    }

    @Listener(event = MyEventType.SWING_DAMAGE)
    public void SwingDamage(Event evt) {
        if (evt.getInitiator().equals(this.initiator)) {
            SwingDamage.add(evt);
        }
    }

    @Listener(event = MyEventType.RANGE_DAMAGE)
    public void RangedDamage(Event evt) {
        if (evt.getInitiator().equals(this.initiator)) {
            RangedDamage.add(evt);
        }
    }

}
