package net_response;

import net.Request;
import net.Response;

/**
 * Created by testuser on 07.01.2018.
 *
 */
public class SuccessResponse implements Response{
    private Request request;

    public SuccessResponse(Request request) {
        this.request = request;
    }

    public Request getRequest() {
        return request;
    }
}
