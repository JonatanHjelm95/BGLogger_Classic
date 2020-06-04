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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;
import java.util.Base64;

/**
 *
 * @author jonab
 */
public class FileHandler {

    public static void FileReaderFromBase64(EventHandler eh, String encodedData) throws FileNotFoundException, IOException {
        Arrays.asList(new String(Base64.getDecoder()
                .decode(encodedData)).split("\n"))
                .stream().map(line -> createInput(line)).collect(Collectors.toList())
                .forEach((i) -> {
                    eh.addEvent(i);
                });
    }

    public static void FileReader(EventHandler eh, String path) throws FileNotFoundException, IOException {
        List<Input> list = new ArrayList();
        try {
            try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
                list = reader.lines().map(line -> createInput(line)).collect(Collectors.toList());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Input i : list) {
            eh.addEvent(i);
        }

    }

    private static Input createInput(String line) {
        //Splitting on whitespaces IOT get date and time
        String[] dates = line.split(" ");
        String date = dates[0];
        String time = dates[1];
        String eventString = dates[3];
        String[] eventSplit = eventString.split(",");

        try {
            return new Input(date, time, eventSplit, MyEventType.valueOf(eventSplit[0]));
        } catch (IllegalArgumentException e) {
            return new Input(date, time, eventSplit, MyEventType.OTHER);
        }
    }

    private static boolean advancedCombatLog(String line) {
        return Integer.parseInt(line.split(",")[3]) == 1;
    }

    public static void main(String[] args) throws IOException {
        String data = "Ni8zIDE1OjQ2OjQ3LjMxOCAgQ09NQkFUX0xPR19WRVJTSU9OLDksQURWQU5DRURfTE9HX0VOQUJMRUQsMSxCVUlMRF9WRVJTSU9OLDEuMTMuNCxQUk9KRUNUX0lELDIKNi8zIDE1OjQ3OjAyLjA0MyAgU1BFTExfQVVSQV9BUFBMSUVELFBsYXllci00NDY3LTAwNTI2Q0EwLCJJbnNwaXJlLUZpcmVtYXciLDB4NTE4LDB4MCxQbGF5ZXItNDQ2Ny0wMDUyNkNBMCwiSW5zcGlyZS1GaXJlbWF3IiwweDUxOCwweDAsMTQzMjIsIkFzcGVjdCBvZiB0aGUgSGF3ayIsMHg4LEJVRkYKNi8zIDE1OjQ3OjI4LjUxNiAgU1dJTkdfREFNQUdFLFBsYXllci00NDY3LTAwNDdBMDc3LCJEcmlsbGVuaXNzZW4tRmlyZW1hdyIsMHg1MTEsMHgwLENyZWF0dXJlLTAtNDQ0OC0xLTEyOS0xMDY4NS0wMDAwRDZGN0YyLCJTd2luZSIsMHgxMGEyOCwweDAsUGxheWVyLTQ0NjctMDA0N0EwNzcsMDAwMDAwMDAwMDAwMDAwMCwxMDAsMTAwLDAsMCwwLC0xLDAsMCwwLDEyMzcuNDcsLTQ1MzAuMTEsMTQxMSwwLjUxOTIsNjMsNTUzLDI3MCw1MzksMSwwLDAsMCwxLG5pbCxuaWwKNi8zIDE1OjQ3OjI4LjkyMCAgUEFSVFlfS0lMTCxQbGF5ZXItNDQ2Ny0wMDQ3QTA3NywiRHJpbGxlbmlzc2VuLUZpcmVtYXciLDB4NTExLDB4MCxDcmVhdHVyZS0wLTQ0NDgtMS0xMjktMTA2ODUtMDAwMEQ2RjdGMiwiU3dpbmUiLDB4MTBhMjgsMHgwCjYvMyAxNTo0NzoyOC45MjAgIFNXSU5HX0RBTUFHRV9MQU5ERUQsUGxheWVyLTQ0NjctMDA0N0EwNzcsIkRyaWxsZW5pc3Nlbi1GaXJlbWF3IiwweDUxMSwweDAsQ3JlYXR1cmUtMC00NDQ4LTEtMTI5LTEwNjg1LTAwMDBENkY3RjIsIlN3aW5lIiwweDEwYTI4LDB4MCxDcmVhdHVyZS0wLTQ0NDgtMS0xMjktMTA2ODUtMDAwMEQ2RjdGMiwwMDAwMDAwMDAwMDAwMDAwLDAsMTAwLDAsMCwwLC0xLDAsMCwwLDEyMzguNDcsLTQ1MjguMDgsMTQxMSw0LjAyNDEsMyw1NTMsMjcwLDUzOSwxLDAsMCwwLDEsbmlsLG5pbAo2LzMgMTU6NDc6MjkuMzE1ICBVTklUX0RJRUQsMDAwMDAwMDAwMDAwMDAwMCxuaWwsMHg4MDAwMDAwMCwweDgwMDAwMDAwLENyZWF0dXJlLTAtNDQ0OC0xLTEyOS0xMDY4NS0wMDAwRDZGN0YyLCJTd2luZSIsMHgxMGEyOCwweDAK";
        FileReaderFromBase64(new EventHandler(), data);
    }
}
