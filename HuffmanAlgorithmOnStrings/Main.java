import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        ArrayList<Node> nodes = new ArrayList<Node>();
        for (int i = 0; i < input.length(); i++) {
            nodes.add(new Node(input.charAt(i), 1));
        }
        HuffmanTree tree = new HuffmanTree(nodes);
        sc.close();
    }
}