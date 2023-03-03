package com.epam.mjc.io;
import java.util.logging.Logger;

import java.io.*;


public class FileReader {

    private final Logger LOGGER = Logger.getLogger(getClass().getName());

    public Profile getDataFromFile(File file) {
        String stri = "";
        StringBuilder bld = new StringBuilder();
        try (FileInputStream newfile = new FileInputStream(file)) {
            int ch;

            while ((ch = newfile.read()) != -1) {
                bld.append((char)ch);
            }
            stri = bld.toString();
        } catch (FileNotFoundException e) {
            LOGGER.severe("Not found");
        } catch (IOException e) {
            LOGGER.severe("missing something");
        }
        String[] pairs = stri.split("\n");
        String[] newpr = new String[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            newpr[i] = (pairs[i].split(": "))[1].trim();
        }

        return  new Profile(newpr[0], Integer.parseInt(newpr[1]), newpr[2], Long.parseLong(newpr[3]));
    }
}
