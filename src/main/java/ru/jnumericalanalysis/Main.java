package ru.jnumericalanalysis;

import ru.jnumericalanalysis.integration.Integrator;
import ru.jnumericalanalysis.integration.IntegratorRiemannImpl;
import ru.jnumericalanalysis.integration.IntegratorTrapezoidalImpl;

import java.math.BigDecimal;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Integrator integrator = new IntegratorTrapezoidalImpl();
        Function<BigDecimal, BigDecimal> function = bigDecimal -> bigDecimal.multiply(bigDecimal);
        BigDecimal space = integrator.integrate(function, BigDecimal.valueOf(0), BigDecimal.TEN, 10000);
        System.out.println(space);
    }
}
