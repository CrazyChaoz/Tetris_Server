package net;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Server extends Instance {
    private ConcurrentMap<String, Game> games = new ConcurrentHashMap<>();
    private ConcurrentMap<String, Person> personConcurrentMap = new ConcurrentHashMap();

    public boolean gameExists(String game) {
        return games.containsKey(game);
    }

    public ConcurrentMap<String, Game> getGames() {
        return games;
    }

    public void addGame(String name, Game game) {
        games.put(name, game);
    }

    public void addPerson(Person p) {
        personConcurrentMap.put(p.getUserID(), p);
    }

    public ConcurrentMap<String, Person> getConnectedPeople() {
        return personConcurrentMap;
    }

    public Game getGame(String gameID) {
        return games.get(gameID);
    }

    public Person getPerson(String userId){
        return personConcurrentMap.get(userId);
    }
}