package net_requests;

import net.Game;
import net.InputKey;
import net.Request;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by testuser on 14.12.2017.
 */
public class PollRequest implements Request {
    private String gameID;
    private Game game;
    private Deque<InputKey> input = new ArrayDeque<>();

    public PollRequest(String gameID) {
        this.gameID = gameID;
    }

    public void addInput(InputKey key) {
        input.addLast(key);
    }

    public Deque<InputKey> getInput() {
        return input;
    }

    public String getGameID() {
        return gameID;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
