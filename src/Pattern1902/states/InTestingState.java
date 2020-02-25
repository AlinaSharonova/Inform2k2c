package Pattern1902.states;

import Pattern1902.State;
import Pattern1902.Task;

import java.util.Arrays;

public class InTestingState extends State {

    public InTestingState(Task task) {
        super(task);
    }

    @Override
    public void up(String... args) {
        getContext().setState(ClosedState.class);
        getContext().setTesterId(null);
        getContext().setDeveloperId(null);
    }

    @Override
    public void down(String... args) {
        getContext().setState(AssignState.class);
        getContext().setError(Arrays.stream(args).reduce(String::concat).orElse(""));

    }
}
