package com.vuluong.designpattern.test.memento;

import com.vuluong.designpattern.memento.TextEditor;
import com.vuluong.designpattern.memento.TextWindow;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MementoTest {

    @Test
    public void test() {
        // given
        TextEditor textEditor = new TextEditor(new TextWindow());

        // when
        textEditor.write("This is the Memento Design Pattern\n");
        textEditor.write("How to implement it in Java?\n");
        textEditor.hitSave();
        textEditor.write("This is something not related!");
        textEditor.hitUndo();

        // then
        assertEquals(
            textEditor.print(),
            "This is the Memento Design Pattern\nHow to implement it in Java?\n"
        );
    }
}
