package com.stevenprogramming.demo.util;

/**
 *
 * @author steven.mendez
 * @since Dec 08 2017
 * @version 1.0
 */
public final class DemoUtil {

    private DemoUtil(){
    }
    
    /**
     * 
     * @param times iteration number of cycles desires
     * @param value StringBuilder to inject result.
     * @param text  base for create suggestions
     * @param secuency 
     */
    public static void appendValue(int times, StringBuilder value, String text, boolean secuency) {
        for (int cont = 0; cont < times; cont++) {
            if (secuency) {
                value.append(text);
                value.append(String.valueOf(cont));
            } else {
                value.append(text);
            }
        }
    }
}
