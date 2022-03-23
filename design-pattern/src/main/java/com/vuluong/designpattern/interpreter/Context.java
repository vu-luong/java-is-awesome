package com.vuluong.designpattern.interpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Context {

    private static Map<String, List<Row>> tables = new HashMap<>();
    static {
        List<Row> list = new ArrayList<>();
        list.add(new Row("Vu", "Luong"));
        list.add(new Row("Foo", "Bar"));
        list.add(new Row("Son", "Goku"));
        tables.put("people", list);
    }

    private String table;
    private String column;
    private int colIndex = -1;
    private static final Predicate<String> matchAnyString = s -> s.length() > 0;
    private static final Function<String, Stream<? extends String>> matchAllColumns = Stream::of;
    private Predicate<String> whereFilter = matchAnyString;
    private Function<String, Stream<? extends String>> columnMapper = matchAllColumns;

}
