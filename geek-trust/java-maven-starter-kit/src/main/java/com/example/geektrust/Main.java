package com.example.geektrust;

import com.example.geektrust.client.DataStreamGenerator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        try {
            DataStreamGenerator streamGenerator = new DataStreamGenerator();
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned
            while (sc.hasNextLine()) {

                streamGenerator.addToStream(sc.nextLine());
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
