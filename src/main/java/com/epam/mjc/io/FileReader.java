package com.epam.mjc.io;

import java.io.*;
import java.util.Arrays;


public class FileReader {


    public Profile getDataFromFile(File file) {
        String stri = "";
        try (FileInputStream newfile = new FileInputStream(file)) {
            int ch;

            while ((ch = newfile.read()) != -1) {
                stri += (char)ch;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Not fount");
        } catch (IOException e) {
            System.out.println("missing something");
        }
        String[] pairs = stri.split("\n");
        System.out.println(pairs[1]);
        String[] newpr = new String[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            newpr[i] = (pairs[i].split(": "))[1].trim();
        }
        String num = newpr[1];


        return  new Profile(newpr[0], Integer.parseInt(newpr[1]), newpr[2], Long.parseLong(newpr[3]));
    }
}
