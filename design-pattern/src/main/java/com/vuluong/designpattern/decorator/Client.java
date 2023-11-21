package com.vuluong.designpattern.decorator;

/**
 * Reference: GoF page 175
 */

public class Client {
    
    public void draw(VisualComponent component) {
        component.draw();
    }

    public static void main(String[] args) {
        Client client = new Client();
        
        // original text view
        VisualComponent textView = new TextView();
        client.draw(textView);
        
        // bordered text view
        System.out.println("---");
        VisualComponent borderedTextView = new BorderDecorator(textView);
        client.draw(borderedTextView);
        
        // bordered scrolled text view
        System.out.println("---");
        VisualComponent borderedScrolledTextView = new BorderDecorator(
            new ScrollDecorator(textView)
        );
        client.draw(borderedScrolledTextView);
    }
}
