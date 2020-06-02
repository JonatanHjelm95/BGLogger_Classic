/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EventHandler;

import java.util.List;

/**
 *
 * @author Martin
 */
public class Input implements Event {

    private final MyEventType _type = MyEventType.SPELL_AURA_APPLIED;
    String _date;
    String _time;
    String[] _data;
    private List<Integer> result;

    @Override
    public MyEventType getEventType() {
        return _type;
    }

    @Override
    public List<Integer> getResult() {
        return result;
    }

    @Override
    public void setDate(String date) {
        _date = date;
    }

    @Override
    public void setTime(String time) {
        _time = time;
    }

    @Override
    public void setData(String[] data) {
        _data = data;
    }

    @Override
    public String getInitiator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
