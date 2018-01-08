package at.htlwels.it.net;

import at.htlwels.it.net_impl.TetrisArena_HELF;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by testuser on 19.12.2017.
 */
public class Game extends Thread {
    private String nameOfTheGame;
    private TetrisArena_HELF arena1, arena2;
    private Player player1, player2;
    private Set<Viewer> viewers;
    private GameState currentState;

    public Game(String nameOfTheGame) {
        arena1 = new TetrisArena_HELF(10, 20);
        arena2 = new TetrisArena_HELF(10, 20);

        player1 = null;
        player2 = null;

        viewers = new HashSet();
        currentState=GameState.GAME_PAUSE;

        this.nameOfTheGame=nameOfTheGame;
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
        if(viewers.contains(viewer))
            viewers.remove(viewer);
        else
            System.err.println("ERR: Viewer Not Found");
    }

    public void addPlayer(Player player) {
        if(player1==null)
            player1=player;
        else if(player2==null)
            player2=player;
        else
            System.err.println("ERR: Already 2 Players Assigned To Game "+nameOfTheGame);
    }

    public void remPlayer(Player player) {
        if(player1==player)
            player1=new AI_Player("b0TTY_player1_"+nameOfTheGame);
        else if(player2==player)
            player2=new AI_Player("b0TTY_player2_"+nameOfTheGame);
        else
            System.err.println("ERR: Player Not Found In Game "+nameOfTheGame);
    }

    public Player getPlayer1(){
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Set<Viewer> getViewers() {
        return viewers;
    }
}
