package at.htlwels.it.net_requests;

import at.htlwels.it.net.Request;

/**
 * Created by testuser on 13.12.2017.
 */
public class CreateRequest implements Request {

    private String gamename;


    public String getGamename() {
        return gamename;
    }

    public CreateRequest(String gamename) {
        this.gamename=gamename;

    }
}
