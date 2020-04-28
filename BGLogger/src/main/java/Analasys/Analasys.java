/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analasys;

/**
 *
 * @author Martin
 */

enum AnalasysTypes{
    DPS,
    Somtehin
}
public interface Analasys {
    public void addData(String _data);
    public Runnable run();
    
    
}
