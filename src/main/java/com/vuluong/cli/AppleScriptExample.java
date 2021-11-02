package com.vuluong.cli;

import java.io.IOException;

/**
 * Refresh the current tab of Chrome
 */
public class AppleScriptExample {

    public static void main(String[] args) throws IOException {
        String[] commands = new String[] {"osascript", "-e", "tell application \"Google Chrome\"\nactivate\ntell application \"System Events\"\ntell process \"Google Chrome\"\nkeystroke \"r\" using {command down, shift down}\nend tell\nend tell\nend tell"};
        Runtime.getRuntime().exec(commands);
    }
}
