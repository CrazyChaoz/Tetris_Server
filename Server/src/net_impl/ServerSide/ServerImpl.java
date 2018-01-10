package net_impl.ServerSide;

import net.*;
import net_requests.*;
import net_response.FailResponse;
import net_response.SuccessResponse;

import java.util.Map;

/**
 * Created by testuser on 14.12.2017.
 */
public class ServerImpl extends Server {



    public static void main(String[] args) {
        ServerImpl server = new ServerImpl();

        new ClientConnectionHandler(server);
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
            getGames().put(request.getGamename(), new Game(request.getGamename(),2));
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

        for (InputKey inputKey : request.getInput()) {
            handleKeyboardHit(inputKey);
        }

        return new SuccessResponse(request);
    }

    @Override
    public Response checkID(CheckIDRequest request) {
        for (Map.Entry<String, Game> games : getGames().entrySet()) {
            for (Player player : games.getValue().getPlayers()) {
                if (player.getUserID().equals(request.getUserID())) {
                    return new FailResponse(new Exception("USERNAME EXISTS"), request);
                }
            }
            for (Viewer viewer : games.getValue().getViewers()) {
                if (viewer.getUserID().equals(request.getUserID())) {
                    return new FailResponse(new Exception("USERNAME EXISTS"), request);
                }
            }
        }
        return new SuccessResponse(request);
    }

    @Override
    public Response joinGame(JoinRequest request) {
        if(gameExists(request.getGameID()) && !getPerson(request.getUserID()).isAssigned()){
                getGame(request.getGameID()).addPlayer((Player) getPerson(request.getUserID()));
        }
        return null;
    }

    @Override
    protected void handleKeyboardHit(InputKey inputKey) {
        
        switch (inputKey){
            case DOWN:
                break;
            case LEFT:
                break;
            case RIGHT:
                break;
            case QUIT:
                break;
            case PAUSE:
                break;
            case SPACE:
                break;
            case ROTATE_LEFT:
                break;
            case ROTATE_RIGHT:
                break;
        }
    }
}
