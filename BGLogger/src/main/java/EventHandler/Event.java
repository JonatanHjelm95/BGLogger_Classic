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



public interface Event{
    
    public void setDate(String date);
    public void setTime(String time);
    public void setData(String[] data);
    public MyEventType getEventType();
    public <T> List<T> getResult();
    public String getInitiator();
}
