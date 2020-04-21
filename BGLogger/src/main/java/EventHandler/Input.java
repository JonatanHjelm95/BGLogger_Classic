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
public class Input implements Event{
    
    private final EventType _type = EventType.INPUT;
    String _data; 
    private List<Integer> result;
    
    @Override
    public EventType getEventType() {
        return _type;
    }

    @Override
    public void Handle() {
        EventHandler handler = EventHandler.getInstance();
        handler.addEvent(new Duel());
    }

    @Override
    public List<Integer> getResult() {
        return result;
    }

    @Override
    public void setData(String data) {
        _data = data;
    }

}
