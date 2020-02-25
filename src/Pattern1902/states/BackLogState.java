package Pattern1902.states;

import Pattern1902.State;
import Pattern1902.Task;

public class BackLogState extends State {

    public BackLogState(Task task) {
        super(task);
    }

    @Override
    public void up(String... args) {
        getContext().setState(OpenState.class);
    }

    @Override
    public void down(String... args) {
        //nothing
    }
}
