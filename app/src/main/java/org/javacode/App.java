/*
 * This source file was generated by the Gradle 'init' task
 */
package org.javacode;

import org.javacode.patterns.prefixsum.ContiguousArray;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        ContiguousArray.findMaxLength(new int[]{0,0,0,1,1,0,0,1,0});
    }
}
