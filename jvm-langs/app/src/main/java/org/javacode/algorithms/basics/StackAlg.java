package org.javacode.algorithms.basics;

import java.util.HashMap;
import java.util.Stack;

public class StackAlg {

    public static boolean validParenthesis(String str) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();

        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');

        for (char c : str.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.peek() == map.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return true;
    }
}
