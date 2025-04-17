package org.javacode;

public class Exercism {

    public static String reverseString(String inputStr) {
        char[] charArray = inputStr.toCharArray();
        int left = 0, right = charArray.length - 1;

        while(left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            left++;
            right--;
        }

        return new String(charArray);
    }
}
