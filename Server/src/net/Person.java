package net;

/**
 * Created by testuser on 20.12.2017.
 */
public abstract class Person extends Thread {
    private PersonState state;
    private String userID;
    private Transmitter transmitter;
    private Game assignedGame;

    public Person(String userID, Transmitter transmitter) {
        this.userID = userID;
        this.transmitter = transmitter;

        assignedGame = null;
    }

    public void assignGame(Game game) {
        this.assignedGame = game;
    }

    public String getUserID() {
        return userID;
    }

    public Transmitter getTransmitter() {
        return transmitter;
    }

    public Game getAssignedGame() {
        return assignedGame;
    }

    public boolean isAssigned() {
        return assignedGame == null ? false : true;
    }

    public PersonState getPersonState() {
        return state;
    }

    public void setPersonState(PersonState state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return userID != null ? userID.equals(person.userID) : person.userID == null;
    }

    @Override
    public int hashCode() {
        return userID != null ? userID.hashCode() : 0;
    }
}
