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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

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
            boolean isAdvanced = advancedCombatLog(line);
            while (line != null) {
                //Splitting on whitespaces IOT get date and time
                String[] dates = line.split(" ");
                String date = dates[0];
                String time = dates[1];
                String eventString = dates[3];
                String[] eventSplit = eventString.split(",");
                
                line = reader.readLine();
                EventHandler eh = new EventHandler();
                eh.addEvent(new Input(date, time, eventSplit));
                

            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public static boolean advancedCombatLog(String line) {
        return Integer.parseInt(line.split(",")[3]) == 1;
    }

    public static void main(String[] args) throws IOException {
        //File file = new File("C:\\Users\\jonab\\Desktop\\WoWCombatLog.txt");
        File file = new File("C:\\Users\\jonab\\.ssh\\4sem\\advProgramming\\BGLogger_Classic\\WoWCombatLog.txt");
        FileReader(file);
    }
}
