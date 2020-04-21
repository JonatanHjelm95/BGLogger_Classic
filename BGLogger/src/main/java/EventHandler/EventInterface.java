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

enum EventType {
  INPUT,
  DUEL,
  MISC
}

public interface EventInterface{
    public void setType(EventType ET);
    public void setData(String data);
    public EventType getEventType();
    public void Handle();
    public <T> List<T> getResult();
    
}
