package net;


import net_requests.*;

public abstract class Instance {
    public abstract Sendable startGame(StartRequest request);

    public abstract Sendable createGame(CreateRequest request);

    public abstract Sendable listGames(ListRequest request);

    public abstract Sendable endGame(EndRequest request);

    public abstract Sendable pollGame(PollRequest request);

    public abstract Sendable checkID(CheckIDRequest request);

    public abstract Sendable joinGame(JoinRequest request);

    protected abstract void handleKeyboardHit(InputKey inputKey);
}