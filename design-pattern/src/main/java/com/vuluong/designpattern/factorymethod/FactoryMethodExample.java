package com.vuluong.designpattern.factorymethod;

public class FactoryMethodExample {
    
    public static void main(String[] args) {
        MazeGame ordinaryGame = new OrdinaryMazeGame();
        MazeGame magicGame = new MagicMazeGame();
        
        ordinaryGame.initGame();
        magicGame.initGame();
    }
}
