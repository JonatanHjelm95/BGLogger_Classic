/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analysis;

import java.util.List;

/**
 *
 * @author Martin
 */
public class ChainedAnalysis extends Analysis implements Plugable{

    public ChainedAnalysis(String _initiator, AnalysisHandler _instance) {
        super(_initiator, _instance);
    }



    @Override
    void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Plug(socket = {ActionAnalysis.class,DamageAnalysis.class})
    @Override
    public void Plug(Result data,String Sender) {
        System.out.println("recieved Data from: "+Sender+" now finishing up my stuff");
    }
    
}
