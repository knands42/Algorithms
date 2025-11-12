package org.javacode.basics;

import org.javacode.algorithms.basics.StackAlg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackAlgTest {

    @Test
    void validParenthesis_success() {
        // given
        String param = "{[()]}";

        // when
        boolean result = StackAlg.validParenthesis(param);

        // then
        assertTrue(result);
    }
}