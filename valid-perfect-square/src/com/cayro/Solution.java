package com.cayro;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {

    public boolean isPerfectSquare(int num) {
        BigDecimal guess = BigDecimal.ONE;
        guess = guess.setScale(3, RoundingMode.HALF_EVEN);
        BigDecimal previousGuess = BigDecimal.ZERO;
        previousGuess = previousGuess.setScale(3, RoundingMode.HALF_EVEN);

        BigDecimal numBd = new BigDecimal(num);
        numBd = numBd.setScale(3, RoundingMode.HALF_EVEN);

        while (true) {
            guess = (guess.add(numBd.divide(guess, RoundingMode.HALF_EVEN))).divide(BigDecimal.valueOf(2), RoundingMode.HALF_EVEN);

            if (guess.equals(previousGuess)) {
                BigDecimal fraction = guess.remainder(BigDecimal.ONE);
                return fraction.doubleValue() < 0.0009;
            }

            previousGuess = guess;
        }
    }

    public boolean isPerfectSquare2(int num) {
        double guess = 1.000;
        double previousGuess = 0.000;

        while (true) {
            guess = (guess + (num / guess)) / 2;

            if (guess == previousGuess) {
                int integer = (int) guess;
                double fraction = guess - integer;
                return fraction < 0.0009;
            }

            previousGuess = guess;
        }
    }
}
