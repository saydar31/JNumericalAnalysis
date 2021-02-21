package ru.jnumericalanalysis.integration;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.Function;

public class IntegratorTrapezoidalImpl implements Integrator {
    @Override
    public BigDecimal integrate(Function<BigDecimal, BigDecimal> function, BigDecimal a, BigDecimal b, int count) {
        BigDecimal result = BigDecimal.ZERO;
        BigDecimal step = b.subtract(a).divide(BigDecimal.valueOf(count), RoundingMode.CEILING);
        BigDecimal left = a;
        while (left.compareTo(b) < 0){
            BigDecimal right = left.add(step);
            BigDecimal leftValue = function.apply(left);
            BigDecimal rightValue = function.apply(right);
            result = result.add(rightValue.add(leftValue).divide(BigDecimal.valueOf(2), RoundingMode.CEILING).multiply(step));
            left = right;
        }
        return result;
    }
}
