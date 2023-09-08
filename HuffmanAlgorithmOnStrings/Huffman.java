import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Huffman {
    private Map<Character, Integer> letters;
    private ArrayList<Node> nodes;

    private ArrayList<Node> formNodesArray(String input, Map<Character, Integer> map) {
        for (int i = 0; i < input.length(); i++) {
            double probability = ((double) map.get(input.charAt(i))) / input.length();
            nodes.add(new Node(input.charAt(i), probability));
        }
        return nodes;
    }

    public Huffman(String input_string) {
        letters = new HashMap();
        nodes = new ArrayList<Node>();
        if (input_string.length() > 0) {
            for (int i = 0; i < input_string.length(); i++) {
                letters.merge(input_string.charAt(i), 1, Integer::sum);
            }
            this.formNodesArray(input_string, letters);
        } else {
            System.out.println("Input string length should be greater than 0");
            System.exit(0);
        }
    }
}