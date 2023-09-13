import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class HuffmanTree {
    final private PriorityQueue<Node> queue;
    private PriorityQueue<Node> temp_queue;
    private String encoded_tree = "";
    public Map<Character, String> codes;

    public HuffmanTree(ArrayList<Node> array) {
        queue = new PriorityQueue<>(new CustomComparator());
        codes = new HashMap();
        for (int i = 0; i < array.size(); i++) {
            Node element = array.get(i);
            if (!queue.contains(element)) {
                queue.add(element);
            }
        }
        this.createQueueCopy();
        System.out.println(queue);
        this.combineNodes();
    }

    public void createQueueCopy() {
        this.temp_queue = new PriorityQueue<>(new CustomComparator());
        Iterator i = this.queue.iterator();
        while (i.hasNext()) {
            temp_queue.add(new Node((Node) i.next()));
        }
    }

    public void combineNodes() {
        Node leftNode = this.temp_queue.poll();
        Node rigthNode = this.temp_queue.poll();
        Node newNode = new Node(leftNode.getProbability() + rigthNode.getProbability());
        newNode.left = leftNode;
        newNode.right = rigthNode;
        temp_queue.add(newNode);
    }

    public Node getHuffmanTreeRoot() {
        while (this.temp_queue.size() > 1) {
            this.combineNodes();
        }
        this.temp_queue.peek().setIsRoot();
        this.temp_queue.peek().setCode("");
        return this.temp_queue.peek();
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
            root.setIsLeaf();
            codes.put(root.getValue(), root.getCode());
        }
    }

    public void encodeHuffmanTree(Node root) {
        if (root.getIsLeaf() == true) {
            this.encoded_tree = this.encoded_tree + "1" + root.getValue();
        } else {
            this.encoded_tree = this.encoded_tree + "0";
            this.encodeHuffmanTree(root.left);
            this.encodeHuffmanTree(root.right);
        }
    }

    public String getEncodedHuffmanTree() {
        if (encoded_tree.equals("")) {
            System.out.println("Encoded Tree string is emty");
            return "Empty";
        } else {
            return this.encoded_tree;
        }
    }

    public Node getDecodedHuffmanTree(String encoded_tree) {
        if (encoded_tree.charAt(0) == '1') {
            encoded_tree.substring(1);
            return new Node(encoded_tree.charAt(0), null, null);
        } else {
            Node leftChild = getDecodedHuffmanTree(encoded_tree.substring(1));
            Node rigthChild = getDecodedHuffmanTree(encoded_tree.substring(1));
            return new Node('0', leftChild, rigthChild);
        }
    }

    public Node decodeHuffmanTree() {
        return new Node(1);
    }

    public void printTree(Node root) {
        if (root.getIsLeaf()) {
            System.out.print(root + " ");
        } else {
            this.printTree(root.left);
            this.printTree(root.right);
        }
    }
}