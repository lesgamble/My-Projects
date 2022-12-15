package com.techelevator.util;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TELog {

    public static void log(String message) {
        DateTimeFormatter timeStamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
        LocalDateTime now = LocalDateTime.now();
        String dateTime = now.format(timeStamp);

        File logFile = new File("logs/search.log");
        try {
            PrintWriter logWriter = new PrintWriter(new FileWriter("exercise/logs/search.log", true));
            logWriter.write(dateTime + "\n" + message + "\n");

            logWriter.close();
        }
        catch (Exception e) {
            throw new TELogException(e.getMessage());
        }

    }
}
