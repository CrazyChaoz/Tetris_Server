package at.htlwels.it.net_requests;

import at.htlwels.it.net.Request;

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
