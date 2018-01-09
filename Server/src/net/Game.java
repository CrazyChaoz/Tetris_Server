package net;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by testuser on 19.12.2017.
 */
public class Game extends Thread {
    private String nameOfTheGame;
    private Set<GameArea> arenas;
    private Set<Player> players;
    private Set<Viewer> viewers;
    private GameState currentState;

    public Game(String nameOfTheGame) {

        arenas = new HashSet();

        players = new HashSet();

        viewers = new HashSet();


        currentState = GameState.GAME_PAUSE;

        this.nameOfTheGame = nameOfTheGame;
    }

    public void _pause() {
        currentState = GameState.GAME_PAUSE;
    }

    public void _resume() {
        currentState = GameState.GAME_RUNNING;
    }

    public void addViewer(Viewer viewer) {
        viewers.add(viewer);
    }

    public void remViewer(Viewer viewer) {
        if (viewers.contains(viewer))
            viewers.remove(viewer);
        else
            System.err.println("ERR: Viewer Not Found");
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void remPlayer(Player player) {
        for (Player player1 : this.players) {
            if (player1.equals(player)) {
                this.players.remove(player);
            }
        }
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public Set<Viewer> getViewers() {
        return viewers;
    }

    public void addArea(GameArea area) {
        this.arenas.add(area);
    }
}
