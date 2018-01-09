package net_requests;

import net.Game;
import net.Request;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by testuser on 14.12.2017.
 */
public class ListRequest implements Request {
    private Deque<Game> gamelist = new ArrayDeque<>();

    public ListRequest() {
    }

    public Deque<Game> getGamelist() {
        return gamelist;
    }

    public void addGame(Game g) {
        gamelist.addLast(g);
    }
}
