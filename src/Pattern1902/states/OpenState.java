package Pattern1902.states;

import Pattern1902.State;
import Pattern1902.Task;

public class OpenState extends State {

    public OpenState(Task task) {
        super(task);
    }

    @Override
    public void up(String... args) {
        getContext().setDeveloperId(Integer.parseInt(args[0]));
        getContext().setState(AssignState.class);
    }

    @Override
    public void down(String... args) {
        getContext().setState(BackLogState.class);
    }
}
