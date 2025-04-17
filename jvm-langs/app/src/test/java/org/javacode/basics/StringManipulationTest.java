package org.javacode.basics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringManipulationTest {

//
    @Test
    void reverseString_success() {
        // given
        String str = "a string";

        // when
        String result = StringManipulation.reverseString(str);

        // then
        assertEquals("gnirts a", result);
    }

    @Test
    void removeDuplicates_success() {
        // given
        String str = "ala";

        // when
        String result = StringManipulation.removeDuplicates(str);

        // then
        assertEquals("al", result);
    }

    @Test
    void hasDuplicates_true() {
        // given
        String str = "ala";

        // when
        Boolean result = StringManipulation.hasDuplicates(str);

        // then
        assertTrue(result);
    }

    @Test
    void isPalindrome_true() {
        // given
        String str = "ala, ala";

        // when
        Boolean result = StringManipulation.isPalindrome(str);

        // then
        assertTrue(result);
    }

    @Test
    void findTheFirstNonRepeatingCharacter_success() {
        // given
        String str = "swiss";

        // when
        Character result = StringManipulation.findTheFirstNonRepeatingCharacter(str);


        // then
        assertEquals('s', result);
    }

    @Test
    void countOccurrencesOfCharacter_success() {
        // given
        String str = "swiss";

        // when
        Integer result = StringManipulation.countOccurrencesOfCharacter(str, 's');


        // then
        assertEquals(3, result);
    }

    @Test
    void areAnagrams_true() {
        // given
        String str1 = "listen";
        String str2 = "silent";

        // when
        Boolean result = StringManipulation.areAnagrams(str1, str2);

        // then
        assertTrue(result);
    }

}
