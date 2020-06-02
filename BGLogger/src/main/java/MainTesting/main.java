/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainTesting;

import Analasys.ActionAnalysis;
import EventHandler.*;
import Listeners.DuelListener;
import Listeners.InputListener;
import Listeners.Listener;
import Listeners.ListenerHolder;
import Listeners.ListenerInterface;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonab
 */
public class main {

    private static int test = 0;

    public static void main(String[] args) {
        /*
        
        eh.addListener(MyEventType.INPUT, new InputListener());
        eh.addListener(MyEventType.DUEL, new DuelListener());
        
        ListenerInterface listener = (Event evt) ->{System.out.println("neeej! et lambda udtryk! "+test); test++;};
        eh.addListener(MyEventType.INPUT, listener);
        Event evt = new Input();
        
        eh.addEvent(evt);

        System.out.println("Event Added");
         */
        ActionAnalysis act = new ActionAnalysis("metoo");
        EventHandler eh = EventHandler.getInstance();
        Class obj = act.getClass();
        Method[] methods = obj.getMethods();
        List<ListenerHolder> listners = new ArrayList<>();
        for (Method method : obj.getMethods()) {
            if (method.isAnnotationPresent(Listener.class)) {
                Listener l = method.getAnnotation(Listener.class);
                listners.add(new ListenerHolder(method,act));     
                eh.addListener(l.event(), new ListenerHolder(method,act));
            }
        }
        
        
        Event evt = new Input();
        
        eh.addEvent(evt);
        //listners.get(0).invoke(null);
        
    }
}
