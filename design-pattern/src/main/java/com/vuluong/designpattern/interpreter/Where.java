package com.vuluong.designpattern.interpreter;

import java.util.List;
import java.util.function.Predicate;

public class Where implements Expression {
    private Predicate<String> filter;

    public Where(Predicate<String> filter) {
        this.filter = filter;
    }

    @Override
    public List<String> interpret(Context ctx) {
        ctx.setFilter(filter);
        return ctx.search();
    }
}
