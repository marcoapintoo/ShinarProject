package org.shinar;

import org.shinar.adapter.java.JavaAdapter;
import org.shinar.formatter.nimrod.NimrodFormatter;

public class Main {

    public static void main(String[] args) {
        JavaAdapter adapter = new JavaAdapter();
        NimrodFormatter formatter = new NimrodFormatter();
        String result = formatter.format(adapter.parseFile("Tests", "Example01.java"));
        System.out.println(result);
    }
}
