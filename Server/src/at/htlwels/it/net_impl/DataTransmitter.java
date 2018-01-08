package at.htlwels.it.net_impl;

import at.htlwels.it.net.Request;
import at.htlwels.it.net.Response;
import at.htlwels.it.net.Transmitter;
import at.htlwels.it.net_response.FailResponse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by testuser on 13.12.2017.
 */
public class DataTransmitter extends Transmitter {


    @Override
    public void open(Socket socket) {
        try {
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            System.err.println("Error on assigning Streams: " + e.getMessage());
        }
    }

    @Override
    public void send(Request request) {

    }

    @Override
    public Response receive() {
        return null;
    }

    @Override
    public void handleFailure(FailResponse failPackage) {

    }

}
