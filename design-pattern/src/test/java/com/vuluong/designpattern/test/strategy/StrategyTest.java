package com.vuluong.designpattern.test.strategy;

import com.vuluong.designpattern.strategy.Discounter;
import com.vuluong.designpattern.strategy.EasterDiscounter;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.vuluong.designpattern.strategy.Discounter.*;
import static org.junit.Assert.assertEquals;

public class StrategyTest {

    @Test
    public void test() {
        Discounter easterDiscounter = new EasterDiscounter();
        BigDecimal discountedValue = easterDiscounter.apply(BigDecimal.valueOf(100));

        assertEquals(discountedValue, BigDecimal.valueOf(50.0));
    }

    @Test
    public void test2() {
        // given
        List<Discounter> discounters = Arrays.asList(
            christmasDiscounter(),
            newYearDiscounter(),
            easterDiscounter()
        );

        BigDecimal amount = BigDecimal.valueOf(100.0);
        BigDecimal actual = discounters.get(0)
            .apply(discounters.get(1).apply(discounters.get(2).apply(amount)));

        // when
        final Discounter combinedDiscounter = discounters
            .stream()
            .reduce(v -> v, Discounter::combine);

        // then
        assertEquals(combinedDiscounter.apply(amount), actual);
    }
}
