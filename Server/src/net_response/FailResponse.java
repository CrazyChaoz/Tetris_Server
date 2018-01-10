package net_response;

import net.Request;
import net.Response;
import net.Sendable;

/**
 * Created by testuser on 17.12.2017.
 */
public class FailResponse implements Response {

    private Exception exceptionThrown;
    private Sendable request;

    public FailResponse(Exception exceptionThrown, Sendable request) {
        this.exceptionThrown = exceptionThrown;
        this.request = request;
    }

    public Exception getExceptionThrown() {
        return exceptionThrown;
    }


    @Override
    public Request getRequest() {
        if (request instanceof Request)
            return (Request) request;
        else
            return null;
    }
}
