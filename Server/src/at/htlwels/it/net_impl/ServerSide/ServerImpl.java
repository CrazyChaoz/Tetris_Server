package at.htlwels.it.net_impl.ServerSide;

import at.htlwels.it.net.Game;
import at.htlwels.it.net.Response;
import at.htlwels.it.net.Server;
import at.htlwels.it.net.Viewer;
import at.htlwels.it.net_requests.*;
import at.htlwels.it.net_response.FailResponse;
import at.htlwels.it.net_response.SuccessResponse;

import java.util.Map;

/**
 * Created by testuser on 14.12.2017.
 */
public class ServerImpl extends Server {

    public static void main(String[] args) {
        ServerImpl server = new ServerImpl();

        ClientConnectionHandler cch = new ClientConnectionHandler(server);
    }

    @Override
    public Response startGame(StartRequest request) {
        if (gameExists(request.getGamename()))
            getGames().get(request.getGamename())._resume();
        return new SuccessResponse(request);
    }

    @Override
    public Response createGame(CreateRequest request) {
        if (gameExists(request.getGamename())) {
            return new FailResponse(new Exception("Game Already exists"), request);
        } else {
            getGames().put(request.getGamename(), new Game(request.getGamename()));
            return new SuccessResponse(request);
        }
    }

    @Override
    public Response listGames(ListRequest request) {
        for (Map.Entry<String, Game> gameEntry : getGames().entrySet()) {
            request.addGame(gameEntry.getValue());
        }

        return new SuccessResponse(request);
    }

    @Override
    public Response endGame(EndRequest request) {
        return null;
    }

    @Override
    public Response pollGame(PollRequest request) {
        request.setGame(getGames().get(request.getGameID()));
        return new SuccessResponse(request);
    }

    @Override
    public Response checkID(CheckIDRequest request) {

        for (Map.Entry<String, Game> games : getGames().entrySet()) {
            if (games.getValue().getPlayer1().getUserID().equals(request.getId()) || games.getValue().getPlayer2().getUserID().equals(request.getId())) {
                return new SuccessResponse(request);
            } else
                for (Viewer viewer : games.getValue().getViewers()) {
                    if (viewer.getUserID().equals(request.getId())) {
                        return new SuccessResponse(request);
                    }
                }
        }
        return new FailResponse(new Exception("USERNAME EXISTS"), request);
    }

    @Override
    public Response joinGame(JoinRequest request) {

        return null;
    }

    @Override
    public Response handleKeyboardHit(KeyboardHitRequest request) {
        return null;
    }
}
