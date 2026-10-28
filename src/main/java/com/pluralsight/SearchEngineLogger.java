package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger {
    public static void main(String[] args)  {
        logAction("launch");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a search term (X or x to exit): ");
            String searchTerms = scanner.nextLine();

            if (searchTerms.equalsIgnoreCase("X")) {
                break;
            }
            logAction("search : " + searchTerms);
        }


        }







    public static void logAction(String action) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateTime = LocalDateTime.now().format(formatter);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("logs.txt", true));

            writer.write(dateTime + " " + action);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Oops, an error occurred." + e.getMessage());

        }
    }
}