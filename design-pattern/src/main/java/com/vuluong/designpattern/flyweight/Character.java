package com.vuluong.designpattern.flyweight;

public class Character implements Glyph {
    
    private final char charcode;

    public Character(char charcode) {
        this.charcode = charcode;
    }

    @Override
    public void draw(Window window, GlyphContext context) {
        System.out.println("drawing '" + this.charcode + "' in " + window + " with " + context);
    }

    @Override
    public void setFont(Font font, GlyphContext context) {
        context.setFont(font);
    }

    @Override
    public Font getFont(GlyphContext context) {
        return context.getFont();
    }

    @Override
    public void first(GlyphContext context) {

    }

    @Override
    public void next(GlyphContext context) {

    }

    @Override
    public boolean isDone(GlyphContext context) {
        return false;
    }

    @Override
    public Glyph current(GlyphContext context) {
        return null;
    }

    @Override
    public void insert(Glyph glyph, GlyphContext context) {

    }

    @Override
    public void remove(GlyphContext context) {

    }
}
