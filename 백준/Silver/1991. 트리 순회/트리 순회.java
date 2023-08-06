import java.util.Scanner;
import java.util.HashMap;

public class Main {
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] input = new String[n];
        String[][] NodeArr = new String[n][3];
        char root;
        HashMap<Character, Node> NodeMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            input[i] = sc.nextLine();
            NodeArr[i] = input[i].split(" ");
            NodeMap.put(NodeArr[i][0].charAt(0), new Node(NodeArr[i][0].charAt(0)));
        }
        root = NodeArr[0][0].charAt(0);

        for (int i = 0; i < n; i++) {
            Node currentNode = NodeMap.get(NodeArr[i][0].charAt(0));
            char left = NodeArr[i][1].charAt(0);
            char right = NodeArr[i][2].charAt(0);

            if (left != '.') currentNode.setLeft(NodeMap.get(left));
            if (right != '.') currentNode.setRight(NodeMap.get(right));
        }

        // 전위 순회
        result.append(NodeMap.get(root).getValue());
        doPreorder(NodeMap.get(root));
        System.out.println(result.toString());
        result.setLength(0);

        // 중위 순회
        doInorder(NodeMap.get(root));
        System.out.println(result.toString());
        result.setLength(0);

        // 후위 순회
        result.append(NodeMap.get(root).getValue());
        doPostorder(NodeMap.get(root));
        System.out.println(result.reverse().toString());
    }

    public static void doPreorder(Node Node) {
        if (Node.getLeft() != null) {
            result.append(Node.getLeft().getValue());
            doPreorder(Node.getLeft());
        }
        if (Node.getRight() != null) {
            result.append(Node.getRight().getValue());
            doPreorder(Node.getRight());
        }
    }
    public static void doInorder(Node Node) {
        if (Node.getLeft() != null) doInorder(Node.getLeft());
        result.append(Node.getValue());
        if (Node.getRight() != null) doInorder(Node.getRight());
    }
    public static void doPostorder(Node Node) {
        if (Node.getRight() != null) {
            result.append(Node.getRight().getValue());
            doPostorder(Node.getRight());
        }
        if (Node.getLeft() != null) {
            result.append(Node.getLeft().getValue());
            doPostorder(Node.getLeft());
        }
    }
}
class Node {
    private final char value;
    private Node left;
    private Node right;

    public Node(char value) {
        left = null;
        right = null;
        this.value = value;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public char getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}