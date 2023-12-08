package com.vuluong.designpattern.flyweight;

public interface Glyph {
    
    void draw(Window window, GlyphContext context);
    void setFont(Font font, GlyphContext context);
    Font getFont(GlyphContext context);
    
    void first(GlyphContext context);
    void next(GlyphContext context);
    boolean isDone(GlyphContext context);
    Glyph current(GlyphContext context);
    
    void insert(Glyph glyph, GlyphContext context);
    void remove(GlyphContext context);
}
