package net;

import net_requests.PollRequest;

public abstract class Client extends Instance {

    protected Transmitter transmitter;
    private PollRequest inputs;

    protected void setTransmitter(Transmitter transmitter) {
        this.transmitter = transmitter;
    }


    protected PollRequest getAndClearPollRequest() {
        PollRequest retval = inputs;
        inputs = null;
        return retval;
    }


    @Override
    protected void handleKeyboardHit(InputKey inputKey) {
        inputs.addInput(inputKey);
    }
}