package com.vuluong.designpattern.flyweight;

public class Application {

    public static void main(String[] args) {
        Font font = new Font("arial");
        GlyphContext context = GlyphContext.builder()
            .font(font)
            .build();
        
        Glyph c = new GlyphFactory().createCharacter('c');
        c.draw(new Window(0, 0, 2, 2), context);
    }
}
