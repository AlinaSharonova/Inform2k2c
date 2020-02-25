package Pattern1902.states;

import Pattern1902.State;
import Pattern1902.Task;

public class AssignState extends State {

    public AssignState(Task task) {
        super(task);
    }

    @Override
    public void up(String... args) {
        getContext().setState(InProgressState.class);
    }

    @Override
    public void down(String... args) {
        getContext().setDeveloperId(null);
        getContext().setState(OpenState.class);
    }
}
