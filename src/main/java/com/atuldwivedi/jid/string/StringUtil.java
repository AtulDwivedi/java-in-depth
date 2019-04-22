package com.atuldwivedi.jid.string;

public class StringUtil {
    public static void main(String[] args) {
        String inputText = "should throw ClassCastException while inserting object which cannot be compared";
        String outputText = inputText.replaceAll(" ", "_");
        System.out.println(outputText);
    }
}
