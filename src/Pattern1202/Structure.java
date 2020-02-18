package Pattern1202;

import java.util.ArrayList;
import java.util.List;

public class Structure {
    public static class Node{
        private String name;
        private List<Node> children;
        private Node parent;
        private Type type;
        //private enum type{COUNTRY, REGION, AREA, TOWN, STREET, HOUSE};
        private int priority;

        public static Builder builder(){ //Паттерн Билдер
            return (new Node()).new Builder();
        }

        public String getName() {
            return name;
        }

        public List<Node> getChildren() {
            return children;
        }

        public Node getParent() {
            return parent;
        }

        public Type getType() {
            return type;
        }

        public int getPriority() {
            return priority;
        }

        public ArrayList<Node> getChild() {
            return List<Node> children;
        }

        public class Builder { //реализация паттерна Билдер

            private Builder() {
            }

            public Builder name(String name){
                Node.this.name = name;
                return this;
            }

            public Builder children(List<Node> children){
                Node.this.children = children;
                return this;
            }

            public Builder parent(Node parent){
                Node.this.parent = parent;
                return this;
            }

            public Builder priority(int priority){
                Node.this.priority = priority;
                return this;
            }

            public Builder type(Type type){
                Node.this.type = type;
                return this;
            }

            public Node build(){
                return Node.this;
            }
        }
    }

    public enum Type{
        COUNTRY,
        REGION,
        DISTRICT,
        TOWN,
        STREET,
        HOUSE;
    }

}
