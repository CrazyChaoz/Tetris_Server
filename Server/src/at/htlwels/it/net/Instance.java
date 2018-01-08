package at.htlwels.it.net;


import at.htlwels.it.net_requests.*;

public abstract class Instance {
    public abstract Response startGame(StartRequest request);
    public abstract Response createGame(CreateRequest request);
    public abstract Response listGames(ListRequest request);
    public abstract Response endGame(EndRequest request);
    public abstract Response pollGame(PollRequest request);
    public abstract Response checkID(CheckIDRequest request);
    public abstract Response joinGame(JoinRequest request);
    public abstract Response handleKeyboardHit(KeyboardHitRequest request);
}