package net_requests;

import net.Request;

/**
 * Created by testuser on 13.12.2017.
 */
public class CreateRequest extends Request {

    private String gamename;


    public String getGamename() {
        return gamename;
    }

    public CreateRequest(String userID,String gameID) {
        super(userID);
        this.gamename=gameID;

    }
}
