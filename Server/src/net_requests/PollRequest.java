package net_requests;

import net.Game;
import net.Request;

/**
 * Created by testuser on 14.12.2017.
 */
public class PollRequest implements Request {
    private String gameID;
    private Game game;

    public PollRequest(String gameID) {
        this.gameID = gameID;
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
