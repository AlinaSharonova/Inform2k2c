package Pattern1902.states;

import Pattern1902.State;
import Pattern1902.Task;

public class ResolvedState extends State {

    public ResolvedState(Task task) {
        super(task);
    }

    @Override
    public void up(String... args) {
        getContext().setTesterId(Integer.parseInt(args[0]));
        getContext().setState(InTestingState.class);
    }

    @Override
    public void down(String... args) {
        getContext().setState(InProgressState.class);
    }
}
