package org.javacode.patterns.slidingwindow;

import org.javacode.algorithms.slidingwindow.LongestSubStringWithoutRepeatingCharacter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LongestSubStringWithoutRepeatingCharacterTest {

    @Test
    public void shouldFindLongestSubstringInBasicString() {
        String input = "abcabcbb";
        
        Integer result = LongestSubStringWithoutRepeatingCharacter.execute(input);
        
        assertEquals(3, result); // "abc" is the longest substring
    }

    @Test
    public void shouldHandleStringWithAllSameCharacters() {
        String input = "bbbbb";
        
        Integer result = LongestSubStringWithoutRepeatingCharacter.execute(input);
        
        assertEquals(1, result); // "b" is the longest substring
    }

    @Test
    public void shouldHandleStringWithNoRepeatingCharacters() {
        String input = "abcdef";
        
        Integer result = LongestSubStringWithoutRepeatingCharacter.execute(input);
        
        assertEquals(6, result); // "abcdef" is the longest substring
    }

    @Test
    public void shouldHandleEmptyString() {
        String input = "";
        
        Integer result = LongestSubStringWithoutRepeatingCharacter.execute(input);
        
        assertEquals(0, result);
    }

    @Test
    public void shouldHandleStringWithSpaces() {
        String input = "ab cd ef";
        
        Integer result = LongestSubStringWithoutRepeatingCharacter.execute(input);
        
        assertEquals(5, result); // "ab cd" is the longest substring
    }

    @Test
    public void shouldHandleStringWithRepeatingPattern() {
        String input = "pwwkew";
        
        Integer result = LongestSubStringWithoutRepeatingCharacter.execute(input);
        
        assertEquals(3, result); // "wke" is the longest substring
    }

    @Test
    public void shouldHandleSingleCharacterString() {
        String input = "a";
        
        Integer result = LongestSubStringWithoutRepeatingCharacter.execute(input);
        
        assertEquals(1, result);
    }

    @Test
    public void shouldHandleStringWithMultipleLongestSubstrings() {
        String input = "dvdf";
        
        Integer result = LongestSubStringWithoutRepeatingCharacter.execute(input);
        
        assertEquals(3, result); // "vdf" is the longest substring
    }

    @Test
    public void shouldHandleStringWithSpecialCharacters() {
        String input = "!@#$%^&*()";
        
        Integer result = LongestSubStringWithoutRepeatingCharacter.execute(input);
        
        assertEquals(10, result); // All characters are unique
    }
} 