package com.duy.text_converter.utils;

import java.util.HashMap;

/**
 * Created by Duy on 15-Jun-17.
 */

public class MorseTool {
    public static final char ALPHABET[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};

    public static final String MORSE_CODE[] = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...",
            "-", "..-", "...-", ".--", "-..-", "-.--", "--..", "/"};
    public static final HashMap<Character, String> TEXT_TO_MORSE_CODES;
    public static final HashMap<String, Character> MORSE_CODE_TO_TEXT;

    static {
        TEXT_TO_MORSE_CODES = new HashMap<>();
        MORSE_CODE_TO_TEXT = new HashMap<>();
        for (int i = 0; i < ALPHABET.length; i++) {
            TEXT_TO_MORSE_CODES.put(ALPHABET[i], MORSE_CODE[i]);
            MORSE_CODE_TO_TEXT.put(MORSE_CODE[i], ALPHABET[i]);
        }
    }

    public static String textToMorse(String text) {
        text = text.toLowerCase();
        StringBuilder converted = new StringBuilder();
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (TEXT_TO_MORSE_CODES.get(chars[i]) != null) {
                converted.append(TEXT_TO_MORSE_CODES.get(chars[i]));
                if (i != chars.length - 1) {
                    converted.append(" ");
                }
            } else {
                converted.append(chars[i]);
            }
        }
        return converted.toString();
    }

    public static String morseToText(String text) {
        text = text.toLowerCase();
        String[] chars = text.split("\\s+");
        StringBuilder converted = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            if (MORSE_CODE_TO_TEXT.get(chars[i]) != null) {
                converted.append(MORSE_CODE_TO_TEXT.get(chars[i]));
            } else {
                converted.append(chars[i]);
            }
        }
        return converted.toString();
    }
}
