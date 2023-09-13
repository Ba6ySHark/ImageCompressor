import java.lang.Character;

class Node {
    private char value;
    private String code;
    private Double probability;
    private boolean isRoot = false;
    private boolean isLeaf = false;
    public Node right = null;
    public Node left = null;

    public Node(char val, double prob) {
        this.value = val;
        this.probability = prob;
    }

    public Node(char val, Node left, Node right) {
        this.value = val;
        this.left = left;
        this.right = right;
    }

    public Node(double prob) {
        System.out.println(this.value);
        this.probability = prob;
    }

    public Node(Node node) {
        this.value = node.getValue();
        this.probability = node.getProbability();
    }

    public void setIsRoot() {
        this.isRoot = true;
    }

    public void setIsLeaf() {
        this.isLeaf = true;
    }

    public void setRigthNode(Node node) {
        this.right = node;
    }

    public void setLeftNode(Node node) {
        this.left = node;
    }

    public void setCode(String value) {
        this.code = value;
    }

    public char getValue() {
        return this.value;
    }

    public Double getProbability() {
        return this.probability;
    }

    public String getCode() {
        return this.code;
    }

    public boolean getIsLeaf() {
        return this.isLeaf;
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