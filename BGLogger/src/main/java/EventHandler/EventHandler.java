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
public class EventHandler {
    private static EventHandler Instance = null; 
    
    private EventHandler(){
        
    }
    
    public static EventHandler getInstance() 
    { 
        if (Instance == null) 
            Instance = new EventHandler(); 
  
        return Instance; 
    } 
    
    private List<EventInterface> eventQue;
    
    public void addEvent(EventInterface _event){
        eventQue.add(_event);
    }
    
}
