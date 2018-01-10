package net_impl;

import net.Game;
import net_impl.tetris_impl.TetrisArena;

/**
 * Created by testuser on 10.01.2018.
 */
public class TetrisGame extends Game {
    public TetrisGame(String nameOfTheGame) {
        super(nameOfTheGame, 2);
    }

    public void addArea() {
        super.addArea(new TetrisArena());
    }
}
