import java.util.PriorityQueue;
import java.util.ArrayList;

class HuffmanTree {
    private PriorityQueue<Node> queue;

    public HuffmanTree(ArrayList<Node> array) {
        queue = new PriorityQueue<>(new CustomComparator());
        for (int i = 0; i < array.size(); i++) {
            Node element = array.get(i);
            if (!queue.contains(element)) {
                queue.add(element);
            }
        }
        System.out.println(queue);
    }
}