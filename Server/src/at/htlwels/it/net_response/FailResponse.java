package at.htlwels.it.net_response;

import at.htlwels.it.net.Request;
import at.htlwels.it.net.Response;

/**
 * Created by testuser on 17.12.2017.
 */
public class FailResponse implements Response {

    private Exception exceptionThrown;
    private Request request;

    public FailResponse(Exception exceptionThrown,Request request) {
        this.exceptionThrown = exceptionThrown;
        this.request=request;
    }

    public Exception getExceptionThrown() {
        return exceptionThrown;
    }

    public Request getRequest() {
        return request;
    }
}
