/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analysis;

import EventHandler.*;
import Listeners.Listener;
import Listeners.ListenerHolder;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Martin
 */
public class AnalysisHandler {

    private List<Analysis> analysis = new ArrayList<>();
    private EventHandler eh = new EventHandler();

    public String getSubmittingPlayer() {
        return "";
    }

    private AnalysisHandler() {
    }

    private void AddListeners(){
        for (Analysis analysi : analysis) {
            Class obj = analysi.getClass();
            Method[] methods = obj.getMethods();
            List<ListenerHolder> listners = new ArrayList<>();
            for (Method method : obj.getMethods()) {
                if (method.isAnnotationPresent(Listener.class)) {
                    Listener l = method.getAnnotation(Listener.class);
                    eh.addListener(l.event(), new ListenerHolder(method, analysi));
                }
            }
        }
    }
    
    public void StartAnalysis(){        
        for (Analysis analysi : analysis) {
            analysi.start();
        }
    }
    
    public void AddAnalysis(Analysis _analysi){
        analysis.add(_analysi);
    }
           
}
