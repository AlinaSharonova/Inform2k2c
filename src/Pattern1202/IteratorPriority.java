package Pattern1202;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.stream.Collectors;

public class IteratorPriority implements Iterator {
    private Structure.Node root;
    private Structure.Node current;
    private Deque<Structure.Node> deque = new ArrayDeque<Structure.Node>();

    public IteratorPriority(Tree tree) {
        setRoot(tree);
        reset();
    }

    public void setRoot(Tree tree){
        root = tree.getRoot();
    }

    public void reset(){
        current = root;
        deque.add(current);
    }

    @Override
    public boolean hasNext() {
        return !deque.isEmpty();
    }

    @Override
    public Object next() {
        current = deque.pollFirst();
        if (current.getChildren() != null) {
            if (!current.getChildren().isEmpty()){
                deque.addAll(current.getChildren().stream().sorted((o1, o2) -> o2.getPriority() - o1.getPriority()).collect(Collectors.toList()));
            }
        }
        return current;
    }
}
