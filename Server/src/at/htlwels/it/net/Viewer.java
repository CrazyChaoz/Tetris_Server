package at.htlwels.it.net;

/**
 * Created by testuser on 20.12.2017.
 */
public class Viewer extends Person {
    public Viewer(String id,Transmitter transmitter){
        super(id,transmitter);
        setPersonState(PersonState.VIEWING);
    }
}
