/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EventHandler;

import Listeners.ListenerInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Singleton event handler. Functions as both que and base handler.
 *
 * @author Martin
 */
public class EventHandler {

    private static EventHandler Instance = null;

    private Map< EventType, List<ListenerInterface>> Listeners = new HashMap<>();

    private EventHandler() {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Runnable runnableTask = () -> {
            try {
                while (true) {
                    EventInterface _event = getEvent();
                    invokeListeners(_event);                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }

    public static EventHandler getInstance() {
        if (Instance == null) {
            Instance = new EventHandler();
        }

        return Instance;
    }

    private List<EventInterface> eventQue;
    ReentrantLock lock = new ReentrantLock();

    public void addEvent(EventInterface _event) {
        lock.lock();
        try {
            eventQue.add(_event);
        } finally {
            lock.unlock();
        }
    }

    private EventInterface getEvent() throws Exception {
        if (eventQue.size() > 0) {
            throw new Exception("Tyyyyraaandeeee.... nooo");
        }
        lock.lock();
        try {
            EventInterface _event = eventQue.get(0);
            eventQue.remove(0);
            return _event;
        } finally {
            lock.unlock();
        }
    }

    public void addListener(EventType _type, ListenerInterface listener) {
        List<ListenerInterface> _listeners = Listeners.get(_type);
        if (_listeners == null) {
            List<ListenerInterface> _list = new ArrayList<>();
            _list.add(listener);
            Listeners.put(_type, _list);
        } else {
            _listeners.add(listener);
        }
    }

    private void invokeListeners(EventInterface _event) {
        for (ListenerInterface _listener : Listeners.get(_event)) {
            _listener.invoke();
        }
    }

}
