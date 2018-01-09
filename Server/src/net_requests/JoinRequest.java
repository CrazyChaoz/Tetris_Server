package net_requests;

import net.Request;

/**
 * Created by testuser on 07.01.2018.
 */
public class JoinRequest implements Request {
    private String gameID;

    public JoinRequest(String gameID) {
        this.gameID = gameID;
    }

    public String getGameID() {
        return gameID;
    }
}
