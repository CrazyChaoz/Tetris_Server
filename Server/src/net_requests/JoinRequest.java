package net_requests;

import net.Request;

/**
 * Created by testuser on 07.01.2018.
 */
public class JoinRequest extends Request {
    private String gameID;

    public JoinRequest(String userID,String gameID) {
        super(userID);
        this.gameID = gameID;
    }

    public String getGameID() {
        return gameID;
    }
}
