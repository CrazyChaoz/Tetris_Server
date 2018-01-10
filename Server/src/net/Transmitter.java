package net;

import net_response.FailResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by testuser on 13.12.2017.
 */
public abstract class Transmitter {

    protected InputStream inputStream;
    protected OutputStream outputStream;

    public abstract void open(Socket socket);

    public abstract void send(Sendable request);

    public abstract Sendable receive();

    public abstract void handleFailure(FailResponse failPackage);

    public void close() {
        try {
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            System.err.println("Error on closing Stream: " + e.getMessage());
        }

    }
}