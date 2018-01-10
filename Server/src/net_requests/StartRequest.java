package net_requests;

import net.Request;

/**
 * Created by testuser on 13.12.2017.
 */
public class StartRequest extends Request {
    private String gamename;

    public StartRequest(String userID,String gamename) {
        super(userID);
        this.gamename = gamename;
    }

    public String getGamename() {
        return gamename;
    }
}
