package net;


public class Player extends Person{

    public Player(String id,Transmitter transmitter) {
        super(id,transmitter);
        setPersonState(PersonState.PLAYING);
    }

    public void win(){
        setPersonState(PersonState.WON);
    }
    public void loose(){
        setPersonState(PersonState.LOST);
    }



}
