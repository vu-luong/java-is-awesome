package com.vuluong;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GreetClientTest {

    @Test
    public void test() throws IOException {
        GreetClient client = new GreetClient();
        client.startConnection("127.0.0.1", 6666);
        String response = client.sendMessage("hello server");
        assertEquals("hello client", response);
    }
}
