package net_requests;

import net.Request;

/**
 * Created by testuser on 14.12.2017.
 */
public class EndRequest implements Request {
    private String gamename;

    public EndRequest(String gamename) {
        this.gamename = gamename;
    }

    public String getGamename() {
        return gamename;
    }
}
