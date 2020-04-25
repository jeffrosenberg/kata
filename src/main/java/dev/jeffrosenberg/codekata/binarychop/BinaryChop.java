package dev.jeffrosenberg.codekata.binarychop;

import java.math.RoundingMode;
import java.util.Arrays;

public class BinaryChop {
    public static int chop(int searchTarget, int[] sortedSearchArray) {
        final int NO_MATCH = -1;
        int lowerBound = 0;
        int upperBound = sortedSearchArray.length;
        int currentPosition;

        if (sortedSearchArray.length == 0) {
            return NO_MATCH;
        }

        do {
            currentPosition = (upperBound + lowerBound) / 2; // integer division; truncates/rounds down
            if (sortedSearchArray[currentPosition] == searchTarget) {
                return currentPosition;
            }
            else if (sortedSearchArray[currentPosition] > searchTarget) {
                upperBound = currentPosition;
            }
            else {
                if (lowerBound == currentPosition) {
                    break;
                }
                lowerBound = currentPosition;
            }
        } while (upperBound > lowerBound);

        return NO_MATCH;
    }

    public static int chop_recursive(int searchTarget, int[] sortedSearchArray) {
        return chop_recursive(searchTarget, sortedSearchArray, 0);
    }
    public static int chop_recursive(int searchTarget, int[] sortedSearchArray, int addToResult) {
        final int NO_MATCH = -1;
        int testPosition = sortedSearchArray.length / 2; // integer division; truncates/rounds down

        if (sortedSearchArray.length == 0) {
            return NO_MATCH;
        }
        else {
            if (sortedSearchArray[testPosition] == searchTarget) {
                return testPosition + addToResult;
            }
            else if (sortedSearchArray.length == 1) {
                return NO_MATCH;
            }
            else if (sortedSearchArray[testPosition] > searchTarget) {
                return chop_recursive(searchTarget, Arrays.copyOfRange(sortedSearchArray, 0, testPosition), addToResult);
            }
            else if (sortedSearchArray[testPosition] < searchTarget) {
                return chop_recursive(searchTarget, Arrays.copyOfRange(sortedSearchArray, testPosition, sortedSearchArray.length), testPosition + addToResult);
            }
            else {
                return NO_MATCH;
            }
        }
    }
}
