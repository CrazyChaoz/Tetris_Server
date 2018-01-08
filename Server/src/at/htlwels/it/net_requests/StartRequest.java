package at.htlwels.it.net_requests;

import at.htlwels.it.net.Request;

/**
 * Created by testuser on 13.12.2017.
 */
public class StartRequest implements Request {
    private String gamename;

    public StartRequest(String gamename) {

        this.gamename = gamename;
    }

    public String getGamename() {
        return gamename;
    }
}
