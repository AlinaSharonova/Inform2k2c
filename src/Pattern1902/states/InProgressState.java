package Pattern1902.states;

import Pattern1902.State;
import Pattern1902.Task;

public class InProgressState extends State {

    public InProgressState(Task task) {
        super(task);
    }

    @Override
    public void up(String... args) {
        getContext().setState(ResolvedState.class);
    }

    @Override
    public void down(String... args) {
        getContext().setState(AssignState.class);
    }
}
