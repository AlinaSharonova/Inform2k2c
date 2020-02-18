package Pattern1202;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class IteratorBFS implements Iterator {

    private Structure.Node root;
    private Structure.Node current;
    private Deque<Structure.Node> deque;

    public IteratorBFS(Tree tree) {
        deque = new ArrayDeque<Structure.Node>();
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
            if (!current.getChildren().isEmpty())
                deque.addAll(current.getChildren());
        }
        return current;
    }
}
