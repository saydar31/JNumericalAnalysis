package ru.jnumericalanalysis.integration;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 *
 */
public interface Integrator {
    BigDecimal integrate(Function<BigDecimal,BigDecimal> function, BigDecimal a, BigDecimal b, int count);
}
