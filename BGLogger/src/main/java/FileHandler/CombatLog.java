/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileHandler;

import EventHandler.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author jonab
 */
public class CombatLog {

    public static void FileReader(File file) throws FileNotFoundException, IOException {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while(line != null){
                System.out.println(line);
                line = reader.readLine();
                Event evt = new Event();
                EventHandler eh = EventHandler.getInstance();
                eh.addEvent(evt);
               
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\jonab\\.ssh\\4sem\\advProgramming\\BGLogger_Classic\\WoWCombatLog.txt");
        FileReader(file);
    }
}
