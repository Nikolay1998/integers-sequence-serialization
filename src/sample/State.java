package sample;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class State {
    private ArrayList<Integer> state;

    public State() {
    }

    public State(ArrayList<Integer> state) {
        this.state = state;
    }

    public ArrayList<Integer> getState() {
        return state;
    }

    public void setState(ArrayList<Integer> state) {
        this.state = state;
    }
}
