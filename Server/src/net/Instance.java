package net;


import net_requests.*;

public abstract class Instance {
    public abstract Response startGame(StartRequest request);

    public abstract Response createGame(CreateRequest request);

    public abstract Response listGames(ListRequest request);

    public abstract Response endGame(EndRequest request);

    public abstract Response pollGame(PollRequest request);

    public abstract Response checkID(CheckIDRequest request);

    public abstract Response joinGame(JoinRequest request);

    protected abstract void handleKeyboardHit(InputKey inputKey);
}