package com.vuluong.designpattern.interpreter;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
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

    void setColumn(String column) {
        this.column = column;
        setColumnMapper();
    }

    void setTable(String table) {
        this.table = table;
    }

    void setFilter(Predicate<String> filter) {
        whereFilter = filter;
    }

    void clear() {
        column = "";
        columnMapper = matchAllColumns;
        whereFilter = matchAnyString;
    }

    List<String> search() {
        List<String> result = tables.entrySet()
            .stream()
            .filter(entry -> entry.getKey().equalsIgnoreCase(table))
            .flatMap(entry -> Stream.of(entry.getValue()))
            .flatMap(Collection::stream)
            .map(Row::toString)
            .flatMap(columnMapper)
            .filter(whereFilter)
            .collect(Collectors.toList());

        clear();
        return result;
    }

    private void setColumnMapper() {
        switch (column) {
            case "*":
                colIndex = -1;
                break;
            case "name":
                colIndex = 0;
                break;
            case "surname":
                colIndex = 1;
                break;
        }

        if (colIndex != -1) {
            columnMapper = s -> Stream.of(s.split(" ")[colIndex]);
        }
    }
}
