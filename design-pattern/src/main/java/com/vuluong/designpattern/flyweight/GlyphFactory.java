package com.vuluong.designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class GlyphFactory {
    
    private Map<Integer, Character> characters;

    public GlyphFactory() {
        characters = new HashMap<>();
    }

    public Character createCharacter(char c) {
        if (!characters.containsKey(c - 'a')) {
            characters.put(c - 'a', new Character(c));
        }
        return characters.get(c - 'a');
    }
}
