package org.javacode.algorithms.basics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class StringManipulation {

    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);

        int leftPointer = 0,
                rightPointer = str.length() - 1;

        while (leftPointer < rightPointer) {
            char tmp = sb.charAt(leftPointer);
            sb.setCharAt(leftPointer, sb.charAt(rightPointer));
            sb.setCharAt(rightPointer, tmp);

            leftPointer++;
            rightPointer--;
        }

        return sb.toString();
    }

    public static String removeDuplicates(String str) {
        LinkedHashSet<Character> linkedHashSet = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (linkedHashSet.add(c)) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static Boolean hasDuplicates(String str) {
        HashSet<Character> hs = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (!hs.add(c)) {
                return true;
            }
        }

        return false;
    }

    public static Boolean isPalindrome(String str) {
        String cleanedStr = str.replaceAll("[^a-zA-Z]", "");
        int leftPointer = 0,
                rightPointer = cleanedStr.length() - 1;

        while (leftPointer < rightPointer) {
            if (cleanedStr.charAt(leftPointer) != cleanedStr.charAt(rightPointer)) {
                return false;
            }

            leftPointer++;
            rightPointer--;
        }

        return true;
    }

    public static Character findTheFirstNonRepeatingCharacter(String str) {
        HashSet<Character> hs = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (!hs.add(c)) {
                return c;
            }
        }

        return null;
    }

    public static Integer countOccurrencesOfCharacter(String str, Character targetChar) {
        int count = 0;

        for (char c : str.toCharArray()) {
            if (c == targetChar) count++;
        }

        return count;
    }

    public static boolean areAnagrams(String str1, String str2) {
        HashMap<Character, Integer> chars = new HashMap<>();

        for (char c : str1.toCharArray()) chars.put(c, chars.getOrDefault(c, 1));

        for (char c : str2.toCharArray()) {
            if (chars.get(c) == 1) {
                chars.remove(c);
            } else if (chars.get(c) == null) {
                return false;
            } else {
                chars.put(c, chars.get(c) - 1);
            }
        }

        return chars.isEmpty();
    }
}