package net_requests;

import net.Request;

/**
 * Created by testuser on 14.12.2017.
 */
public class EndRequest extends Request {
    private String gamename;

    public EndRequest(String userID,String gameID) {
        super(userID);
        this.gamename = gameID;
    }

    public String getGamename() {
        return gamename;
    }
}
