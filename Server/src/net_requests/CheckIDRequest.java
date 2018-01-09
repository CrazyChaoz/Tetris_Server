package net_requests;

import net.PersonState;
import net.Request;

/**
 * Created by testuser on 20.12.2017.
 */
public class CheckIDRequest implements Request {

    private String id;
    private PersonState state;

    public CheckIDRequest(String id,PersonState state) {
        this.id = id;
        this.state=state;
    }

    public String getId() {
        return id;
    }

    public PersonState getState(){
        return state;
    }

}
