package at.htlwels.it.net_response;

import at.htlwels.it.net.Request;
import at.htlwels.it.net.Response;

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
