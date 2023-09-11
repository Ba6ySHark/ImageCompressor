import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class HuffmanTree {
    public Map<Character, String> codes;
    private PriorityQueue<Node> queue;

    public HuffmanTree(ArrayList<Node> array) {
        queue = new PriorityQueue<>(new CustomComparator());
        codes = new HashMap();
        for (int i = 0; i < array.size(); i++) {
            Node element = array.get(i);
            if (!queue.contains(element)) {
                queue.add(element);
            }
        }
        System.out.println(queue);
        this.combineNodes();
    }

    public void combineNodes() {
        Node leftNode = this.queue.poll();
        Node rigthNode = this.queue.poll();
        Node newNode = new Node(leftNode.getProbability() + rigthNode.getProbability());
        newNode.left = leftNode;
        newNode.right = rigthNode;
        queue.add(newNode);
    }

    public Node getHuffmanTreeRoot() {
        while (this.queue.size() > 1) {
            this.combineNodes();
        }
        this.queue.peek().setIsRoot();
        this.queue.peek().setCode("");
        return this.queue.peek();
    }

    public void visitNode(Node root) {
        if (root.left != null) {
            root.left.setCode(root.getCode() + Integer.toString(0));
            visitNode(root.left);
        }
        if (root.right != null) {
            root.right.setCode(root.getCode() + Integer.toString(1));
            visitNode(root.right);
        }
        if (root.left == null && root.right == null) {
            codes.put(root.getValue(), root.getCode());
        }
    }
}