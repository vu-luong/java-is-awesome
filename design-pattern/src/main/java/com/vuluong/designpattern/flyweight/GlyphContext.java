package com.vuluong.designpattern.flyweight;

import lombok.Builder;

@Builder
public class GlyphContext {

    private Font font;

    public void next(int step) {

    }

    public void insert() {

    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    @Override
    public String toString() {
        return "Context{font=" + font + "}";
    }
}
