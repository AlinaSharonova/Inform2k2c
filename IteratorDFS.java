package Pattern1202;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class IteratorDFS implements Iterator {
    private Structure.Node root;
    private Structure.Node current;
    private Deque<Structure.Node> deque;

    public IteratorDFS(Tree tree) {
        deque = new ArrayDeque<>();
        fillDeque();
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
    public Structure.Node next() {
        current = deque.pollLast();
        if (deque.peekLast() != null){
            Structure.Node parent = current.getParent();
            if (parent != null){
                parent.getChildren().remove(current);
                if (!deque.contains(parent)){
                    deque.add(parent);
                }
                if (!parent.getChildren().isEmpty()){
                    if(!deque.containsAll(parent.getChildren())){
                        deque.addAll(parent.getChildren());
                    }
                }
            }
            while(!current.getChildren().isEmpty()){
                if(!deque.containsAll(current.getChildren())){
                    Structure.Node helpNode = current;
                    deque.add(current);
                    deque.addAll(current.getChildren());
                    current = deque.pollLast();
                    helpNode.getChildren().remove(current);
                }
            }
        }
        return current;
    }

    public void fillDeque(){
        deque.add(root);
        current = root;
        while(current.getChildren() != null) {
            Structure.Node child = current.getChildren().get(0);
            deque.add(child);
            current = child;
        }
    }
}
