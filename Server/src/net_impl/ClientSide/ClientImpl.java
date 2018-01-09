package net_impl.ClientSide;


import net.Client;
import net.InputKey;
import net.Response;
import net.Transmitter;
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

        Transmitter transmitter = new ObjectTransmitter();
        transmitter.open(new Socket("127.0.0.1", 12345));
        ClientImpl client = new ClientImpl();

        client.createGame(new CreateRequest("Game-1"));
        client.joinGame(new JoinRequest("Game-1"));

        //Should only work with {2} Players
        client.startGame(new StartRequest("Game-1"));



        //TODO: Loop The Input, Sending & Polling
        //TODO: Use Userinput
        client.handleKeyboardHit(InputKey.LEFT);
        client.handleKeyboardHit(InputKey.LEFT);
        client.handleKeyboardHit(InputKey.DOWN);

        transmitter.send(client.getAndClearPollRequest());
        client.pollGame(new PollRequest("Game-1"));

    }

    @Override
    public Response startGame(StartRequest request) {
        transmitter.send(request);
        return transmitter.receive();
    }

    @Override
    public Response createGame(CreateRequest request) {
        transmitter.send(request);
        return transmitter.receive();
    }

    @Override
    public Response listGames(ListRequest request) {
        transmitter.send(request);
        return transmitter.receive();
    }

    @Override
    public Response endGame(EndRequest request) {
        transmitter.send(request);
        return transmitter.receive();
    }

    @Override
    public Response pollGame(PollRequest request) {
        transmitter.send(request);
        return transmitter.receive();
    }

    @Override
    public Response checkID(CheckIDRequest request) {
        transmitter.send(request);
        return transmitter.receive();
    }

    @Override
    public Response joinGame(JoinRequest request) {
        transmitter.send(request);
        return transmitter.receive();
    }
}
