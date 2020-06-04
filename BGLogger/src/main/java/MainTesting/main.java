/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainTesting;

import Analysis.ActionAnalysis;
import EventHandler.*;
import Listeners.Listener;
import Listeners.ListenerHolder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
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
         
        ActionAnalysis act = new ActionAnalysis("metoo");
        EventHandler eh = new EventHandler();
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
         */
        
        long t0 = (long)0;
        Event e0 = new Duel();
        Date d = new Date();
        d.setTime(100);
        e0.setDate(d);
        
        Event e1 = new Duel();
        Date d1 = new Date();
        d1.setTime(200);
        e1.setDate(d1);
        
        Event e11= new Duel();
        e11.setDate(d1);
        
        Event e2 = new Duel();
        Date d2 = new Date();
        d2.setTime(300);
        e2.setDate(d1);
        
        Event e3 = new Duel();
        e3.setDate(d2);
        
        Event e4 = new Duel();
        e4.setDate(d2);
        
        Event[] arr = {e0,e1,e11,e2,e3,e4};
        List<Event> l= Arrays.asList(arr);
        

    }
}
