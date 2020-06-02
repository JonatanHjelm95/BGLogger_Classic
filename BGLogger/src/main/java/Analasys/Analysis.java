/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analasys;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Martin
 */
enum AnalasysTypes {
    DPS,
    Somtehin
}


public abstract class Analysis {
    private final String initiator;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    public Analysis(String _initiator){
        initiator = _initiator;
    }
    
    private Runnable AsRunnable() {
        Runnable runnableTask = () -> {
            setup();
            run();
            shutdown();
        };
        return runnableTask;
    }
    private void setup(){};

    abstract void run();

    private void shutdown() {};

    public void start() {
        executor.submit(AsRunnable());
        executor.shutdown();
    }

}
