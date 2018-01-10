package net_impl.ClientSide;


import net.*;
import net_impl.ObjectTransmitter;
import net_requests.*;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by testuser on 13.12.2017.
 */


/**
 * this class is used for communicating with the server
 */
public class ClientImpl extends Client {


    public static void main(String[] args) throws IOException {

        /**
        * Communication Example
        * */
        //TODO: Input by GUI

        String id="Battus Mannus";
        Transmitter transmitter = new ObjectTransmitter();
        transmitter.open(new Socket("127.0.0.1", 12345));
        ClientImpl client = new ClientImpl();

        client.createGame(new CreateRequest(id,"Game-1"));
        client.joinGame(new JoinRequest(id,"Game-1"));

        //Should only work with {2} Players
        client.startGame(new StartRequest(id,"Game-1"));



        //TODO: Loop The Input, Sending & Polling
        //TODO: Use Userinput
        client.handleKeyboardHit(InputKey.LEFT);
        client.handleKeyboardHit(InputKey.LEFT);
        client.handleKeyboardHit(InputKey.DOWN);

        client.pollGame(client.getAndClearPollRequest());

    }

    @Override
    public Sendable startGame(StartRequest request) {
        transmitter.send(request);
        return transmitter.receive();
    }

    @Override
    public Sendable createGame(CreateRequest request) {
        transmitter.send(request);
        return transmitter.receive();
    }

    @Override
    public Sendable listGames(ListRequest request) {
        transmitter.send(request);
        return transmitter.receive();
    }

    @Override
    public Sendable endGame(EndRequest request) {
        transmitter.send(request);
        return transmitter.receive();
    }

    @Override
    public Sendable pollGame(PollRequest request) {
        transmitter.send(request);
        return transmitter.receive();
    }

    @Override
    public Sendable checkID(CheckIDRequest request) {
        transmitter.send(request);
        return transmitter.receive();
    }

    @Override
    public Sendable joinGame(JoinRequest request) {
        transmitter.send(request);
        return transmitter.receive();
    }
}
