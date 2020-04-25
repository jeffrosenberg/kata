package dev.jeffrosenberg.codekata.binarychop;

import java.math.RoundingMode;

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
}
