package net_impl;

import net.Request;
import net.Response;
import net.Transmitter;
import net_response.FailResponse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by testuser on 13.12.2017.
 */
public class ObjectTransmitter extends Transmitter {

    @Override
    public void open(Socket socket) {
        try {
            inputStream = new ObjectInputStream(socket.getInputStream());
            outputStream = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            System.err.println("Error on assigning Streams: " + e.getMessage());
        }
    }

    @Override
    public void send(Request object) {
        try {
            ((ObjectOutputStream) outputStream).writeObject(object);
        } catch (IOException e) {
            System.err.println("Error on sending Object to Stream: " + e.getMessage());
        }
    }

    @Override
    public Response receive() {
        try {
            Response request = (Response) ((ObjectInputStream) inputStream).readObject();
            if (request instanceof FailResponse) {
                handleFailure((FailResponse) request);
                return null;
            }
            return request;
        } catch (IOException e) {
            System.err.println("Error on reading Object from Stream: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Error on reading Object: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void handleFailure(FailResponse failPackage) {
        // Remote Exception, no handling atm
        System.err.println(failPackage.getExceptionThrown().getMessage());
    }
}
