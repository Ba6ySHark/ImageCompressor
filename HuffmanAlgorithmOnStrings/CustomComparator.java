import java.util.Comparator;

class CustomComparator implements Comparator<Node> {
    @Override
    public int compare(Node firstNode, Node secondNode) {
        int value = firstNode.getProbability().compareTo(secondNode.getProbability());
        if (value > 0) {
            return 1;
        } else if (value < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}