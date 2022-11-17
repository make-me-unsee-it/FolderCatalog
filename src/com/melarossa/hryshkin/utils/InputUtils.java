package com.melarossa.hryshkin.utils;

import java.util.regex.Pattern;

public class InputUtils {
    public static String[] commandToRootSequence(String input) {
        Pattern p = Pattern.compile("/");
        return p.split(input);
    }

    public static boolean isFileCheck(String input) {
        return Pattern.matches("\\w+\\.\\w+", input);
    }

}
