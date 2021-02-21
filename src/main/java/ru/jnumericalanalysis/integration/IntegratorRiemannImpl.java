package ru.jnumericalanalysis.integration;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.Function;

public class IntegratorRiemannImpl implements Integrator {
    @Override
    public BigDecimal integrate(Function<BigDecimal, BigDecimal> function, BigDecimal a, BigDecimal b, int count) {
        BigDecimal result = BigDecimal.ZERO;
        BigDecimal step = b.subtract(a).divide(BigDecimal.valueOf(count), RoundingMode.CEILING);
        for (BigDecimal left = a; left.compareTo(b) < 0;left = left.add(step)){
            result = result.add(function.apply(left).multiply(step).abs());
        }
        return result;
    }
}
