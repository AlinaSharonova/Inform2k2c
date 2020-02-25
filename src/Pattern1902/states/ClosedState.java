package Pattern1902.states;

import Pattern1902.State;
import Pattern1902.Task;

public class ClosedState extends State {

    public ClosedState(Task task) {
        super(task);
    }

    @Override
    public void up(String... args) {
        //nothing
    }

    @Override
    public void down(String... args) {
        //nothing
    }
}
