package com;
import java.util.regex.Pattern;

public class ElementCounter {
    private ElementCounter(){
    }

    public static String[] count(String input) {
        Pattern p = Pattern.compile("/");
        return p.split(input);
    }

    public static boolean isFile(String input) {
        return Pattern.matches("\\w+\\.\\w+", input);
    }
}
