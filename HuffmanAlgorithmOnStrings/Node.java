import java.lang.Character;

class Node {
    private char value;
    private Double probability;

    public Node(char val, double prob) {
        this.value = val;
        this.probability = prob;
    }

    public char getValue() {
        return this.value;
    }

    public Double getProbability() {
        return this.probability;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (!(obj instanceof Node)) {
            return false;
        } else {
            Node node = (Node) obj;
            return Character.compare(this.value, node.getValue()) == 0;
        }
    }

    @Override
    public String toString() {
        return "Node: " + this.value + " " + this.probability;
    }
}