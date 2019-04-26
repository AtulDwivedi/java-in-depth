package com.atuldwivedi.jid.collection.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Balanced {

    public static void main(String[] args) {
        String bal = "{{[[(([]))]]}}";
        String result = "un-balanced";

        Map<String, String> map = new HashMap<>();
        map.put("}", "{");
        map.put("]", "[");
        map.put(")", "(");

        if (bal.length() % 2 == 0) {

            Stack<String> stack = new Stack<>();

            char[] allArr = bal.toCharArray();

            for (int i = 0; i < allArr.length; i++) {
                String current = allArr[i] + "";
                if (map.entrySet().stream().anyMatch(e -> e.getValue().equals(current))) {
                    stack.push(current);
                } else if (!stack.empty() && map.get(current).equals(stack.peek())) {
                    stack.pop();
                }
            }

            if (stack.size() == 0) {
                result = "balanced";
            }
        }
        System.out.println(result);
    }
}
