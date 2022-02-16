package com.vuluong.designpattern.factorymethod;

import java.util.ArrayList;
import java.util.List;

public abstract class MazeGame {
    private final List<Room> rooms = new ArrayList<>();
    
    /**
     * Do common logic
     */
    public void initGame() {
        Room room1 = makeRoom();
        Room room2 = makeRoom();
        room1.connect(room2);
        rooms.add(room1);
        rooms.add(room2);
        System.out.println(rooms);
    }
    
    abstract protected Room makeRoom();
}
