package at.htlwels.it.net_requests;

import at.htlwels.it.net.InputKey;
import at.htlwels.it.net.Request;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by testuser on 07.01.2018.
 */
public class KeyboardHitRequest implements Request{
    private Deque<InputKey> input=new ArrayDeque<>();

    public void addInput(InputKey key){
        input.addLast(key);
    }

    public Deque<InputKey> getInput() {
        return input;
    }
}
