package at.htlwels.it.net_impl.ServerSide;

import at.htlwels.it.net.*;
import at.htlwels.it.net.*;
import at.htlwels.it.net_impl.ObjectTransmitter;
import at.htlwels.it.net_requests.*;
import at.htlwels.it.net_requests.*;
import at.htlwels.it.net_response.FailResponse;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by testuser on 20.12.2017.
 */

public class ClientConnectionHandler extends Thread {
    private static boolean runFurther = true;
    private Server server;

    public ClientConnectionHandler(Server server) {
        this.server = server;
        try {
            this.start();
        } catch (Exception ignored) {
        }
    }

    @Override
    public void run() {
        try {
            Socket s = new ServerSocket(12345).accept();
            if (runFurther)
                new ClientConnectionHandler(server).start();


            Transmitter t = new ObjectTransmitter();
            t.open(s);

            Person p = idConfig(t);
            server.addPerson(p);

            for (; ; ) {

                Request request = t.receive();
                Response response = null;
                if (request instanceof CheckIDRequest) {
                    response = server.checkID((CheckIDRequest) request);
                } else if (request instanceof CreateRequest) {
                    response = server.createGame((CreateRequest) request);
                } else if (request instanceof EndRequest) {
                    response = server.endGame((EndRequest) request);
                } else if (request instanceof JoinRequest) {
                    response = server.joinGame((JoinRequest) request);
                } else if (request instanceof KeyboardHitRequest) {
                    response = server.handleKeyboardHit((KeyboardHitRequest) request);
                } else if (request instanceof ListRequest) {
                    response = server.listGames((ListRequest) request);
                } else if (request instanceof PollRequest) {
                    response = server.pollGame((PollRequest) request);
                } else if (request instanceof StartRequest) {
                    response = server.startGame((StartRequest) request);
                }
                t.send(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void killConnectionManager() {
        this.stop();
    }

    public Person idConfig(Transmitter t) {
        String id = null;
        Person p = null;
        Response request = null;

        do {
            request = t.receive();
            Request checkIDRequest = request.getRequest();
            if (!(checkIDRequest instanceof CheckIDRequest))
                currentThread().interrupt();
            request = server.checkID((CheckIDRequest) checkIDRequest);
            t.send(request);
        } while (request instanceof FailResponse);

        switch (((CheckIDRequest) request.getRequest()).getState()) {
            case PLAYING:
                p = new Player(((CheckIDRequest) request.getRequest()).getId(), t);
                break;
            case VIEWING:
                p = new Viewer(((CheckIDRequest) request.getRequest()).getId(), t);
                break;
        }

        return p;
    }
}
