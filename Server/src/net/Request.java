package net;

import java.io.Serializable;

/**
 * Created by testuser on 13.12.2017.
 */
public abstract class Request implements Serializable,Sendable {
    private String userID;

    public Request(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    @Override
    public Request getRequest() {
        return this;
    }
}
