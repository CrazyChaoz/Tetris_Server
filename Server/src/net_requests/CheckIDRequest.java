package net_requests;

import net.PersonState;
import net.Request;

/**
 * Created by testuser on 20.12.2017.
 */
public class CheckIDRequest extends Request {
    private PersonState state;

    public CheckIDRequest(String id, PersonState state) {
        super(id);
        this.state = state;
    }

    public PersonState getState() {
        return state;
    }

}
