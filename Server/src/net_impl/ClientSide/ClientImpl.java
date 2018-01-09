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
 * this class is used for processing servers response
 */
public class ClientImpl extends Client {

    private Transmitter transmitter;

    public ClientImpl(Transmitter transmitter) {
        this.transmitter = transmitter;
    }

    public static void main(String[] args) throws IOException {

        Transmitter transmitter = new ObjectTransmitter();
        transmitter.open(new Socket("127.0.0.1", 12345));
        ClientImpl client = new ClientImpl(transmitter);

        client.createGame(new CreateRequest("Game-1"));
        client.joinGame(new JoinRequest("Game-1"));
        client.startGame(new StartRequest("Game-1"));

        client.pollGame(new PollRequest("Game-1"));


        KeyboardHitRequest keyHits=new KeyboardHitRequest();
        keyHits.addInput(InputKey.DOWN);
        keyHits.addInput(InputKey.LEFT);

        transmitter.send(keyHits);
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

    @Override
    public Response handleKeyboardHit(KeyboardHitRequest request) {
        return null;
    }

}
