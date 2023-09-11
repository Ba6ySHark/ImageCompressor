import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Huffman {
    private Map<Character, Integer> letters;
    private ArrayList<Node> nodes;
    private String original_text;
    FileHandler file_handler = new FileHandler();

    private ArrayList<Node> formNodesArray(String input, Map<Character, Integer> map) {
        ArrayList<Node> temp = new ArrayList<Node>();
        for (int i = 0; i < input.length(); i++) {
            double probability = ((double) map.get(input.charAt(i))) / input.length();
            temp.add(new Node(input.charAt(i), probability));
        }
        return temp;
    }

    public Huffman(String input_string) {
        letters = new HashMap();
        nodes = new ArrayList<Node>();
        this.original_text = input_string;
        if (input_string.length() > 0) {
            for (int i = 0; i < input_string.length(); i++) {
                letters.merge(input_string.charAt(i), 1, Integer::sum);
            }
            nodes = this.formNodesArray(input_string, letters);
            HuffmanTree tree = new HuffmanTree(nodes);
            // System.out.println(tree.getHuffmanTreeRoot());
            tree.visitNode(tree.getHuffmanTreeRoot());
            System.out.println(tree.codes);
            file_handler.writeBytes(this.encode(tree.codes), "out.txt");
        } else {
            System.out.println("Input string length should be greater than 0");
            System.exit(0);
        }
    }

    public byte[] encode(Map<Character, String> char_codes) {
        String encoded_string = "";
        byte[] bytes_repr;
        for (int i = 0; i < this.original_text.length(); i++) {
            encoded_string = encoded_string + char_codes.get(original_text.charAt(i));
        }
        bytes_repr = encoded_string.getBytes();
        String out = "";
        for (int i = 0; i < bytes_repr.length; i++) {
            out = out + bytes_repr[i];
        }
        System.out.println(encoded_string);
        String sub = "";
        int counter = 0;
        for (int i = 0; i < encoded_string.length(); i++) {
            counter++;
            if (counter == 8) {
                System.out.print(Integer.parseInt(sub, 2) + " ");
                sub = "";
                counter = 0;
            } else {
                sub = sub + encoded_string.charAt(i);
            }
        }
        System.out.println();
        System.out.println(out);
        return bytes_repr;
    }
}