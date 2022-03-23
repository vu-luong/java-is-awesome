package com.vuluong.designpattern.interpreter;

import java.util.List;

public interface Expression {
    List<String> interpret(Context ctx);
}
