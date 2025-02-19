package org.kotlincode.patterns.slidingwindow

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

class LongestSubStringWithoutRepeatingCharacterTest {
    
    private lateinit var solution: LongestSubStringWithoutRepeatingCharacter
    
    @BeforeEach
    fun setup() {
        solution = LongestSubStringWithoutRepeatingCharacter()
    }

    @Test
    fun `should find longest substring in basic string`() {
        val input = "abcabcbb"
        
        val result = solution.execute(input)
        
        assertEquals(3, result) // "abc" is the longest substring
    }

    @Test
    fun `should handle string with all same characters`() {
        val input = "bbbbb"
        
        val result = solution.execute(input)
        
        assertEquals(1, result) // "b" is the longest substring
    }

    @Test
    fun `should handle string with no repeating characters`() {
        val input = "abcdef"
        
        val result = solution.execute(input)
        
        assertEquals(6, result) // "abcdef" is the longest substring
    }

    @Test
    fun `should handle empty string`() {
        val input = ""
        
        val result = solution.execute(input)
        
        assertEquals(0, result)
    }

    @Test
    fun `should handle string with spaces`() {
        val input = "ab cd ef"
        
        val result = solution.execute(input)
        
        assertEquals(5, result) // "ab cd" is the longest substring
    }

    @Test
    fun `should handle string with repeating pattern`() {
        val input = "pwwkew"
        
        val result = solution.execute(input)
        
        assertEquals(3, result) // "wke" is the longest substring
    }

    @Test
    fun `should handle single character string`() {
        val input = "a"
        
        val result = solution.execute(input)
        
        assertEquals(1, result)
    }

    @Test
    fun `should handle string with multiple longest substrings`() {
        val input = "dvdf"
        
        val result = solution.execute(input)
        
        assertEquals(3, result) // "vdf" is the longest substring
    }
} 