package dev.jeffrosenberg.codekata.binarychop;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static dev.jeffrosenberg.codekata.binarychop.BinaryChop.chop;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@Tag("java")
public class BinaryChopTest {
    @ParameterizedTest
    @MethodSource("binarySearchTestCases")
    void binarySearchParameterizedTest(int expected, int searchTarget, int[] sortedSearchArray) {
        assertEquals(expected, chop(searchTarget, sortedSearchArray));
    }

    static Stream<Arguments> binarySearchTestCases() {
        return Stream.of(
                arguments(-1, -1, new int[]{ }),
                arguments(-1, -1, new int[]{1}),
                arguments(0, 1, new int[]{1}),

                arguments(0,  1, new int[]{1, 3, 5}),
                arguments(1,  3, new int[]{1, 3, 5}),
                arguments(2,  5, new int[]{1, 3, 5}),
                arguments(-1, 0, new int[]{1, 3, 5}),
                arguments(-1, 2, new int[]{1, 3, 5}),
                arguments(-1, 4, new int[]{1, 3, 5}),
                arguments(-1, 6, new int[]{1, 3, 5}),

                arguments(0,  1, new int[]{1, 3, 5, 7}),
                arguments(1,  3, new int[]{1, 3, 5, 7}),
                arguments(2,  5, new int[]{1, 3, 5, 7}),
                arguments(3,  7, new int[]{1, 3, 5, 7}),
                arguments(-1, 0, new int[]{1, 3, 5, 7}),
                arguments(-1, 2, new int[]{1, 3, 5, 7}),
                arguments(-1, 4, new int[]{1, 3, 5, 7}),
                arguments(-1, 6, new int[]{1, 3, 5, 7}),
                arguments(-1, 8, new int[]{1, 3, 5, 7}),

                arguments(1,  2, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}),
                arguments(5,  6, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}),
                arguments(-1,  0, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})
        );
    }
}

/*
def test_chop
  assert_equal(-1, chop(3, []))
  assert_equal(-1, chop(3, [1]))
  assert_equal(0,  chop(1, [1]))
  #
end
 */