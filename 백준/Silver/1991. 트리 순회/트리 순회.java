import java.util.Scanner;
import java.util.HashMap;

public class Main {
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] input = new String[n];
        String[][] treeArr = new String[n][3];
        char root;
        HashMap<Character, Tree> treeMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            input[i] = sc.nextLine();
            treeArr[i] = input[i].split(" ");
            treeMap.put(treeArr[i][0].charAt(0), new Tree(treeArr[i][0].charAt(0)));
        }
        root = treeArr[0][0].charAt(0);

        for (int i = 0; i < n; i++) {
            Tree currentTree = treeMap.get(treeArr[i][0].charAt(0));
            char left = treeArr[i][1].charAt(0);
            char right = treeArr[i][2].charAt(0);

            if (left != '.') currentTree.setLeft(treeMap.get(left));
            if (right != '.') currentTree.setRight(treeMap.get(right));
        }

        // 전위 순회
        result.append(treeMap.get(root).getValue());
        doPreorder(treeMap.get(root));
        System.out.println(result.toString());
        result.setLength(0);

        // 중위 순회
        doInorder(treeMap.get(root));
        System.out.println(result.toString());
        result.setLength(0);

        // 후위 순회
        result.append(treeMap.get(root).getValue());
        doPostorder(treeMap.get(root));
        System.out.println(result.reverse().toString());
    }

    public static void doPreorder(Tree tree) {
        if (tree.getLeft() != null) {
            result.append(tree.getLeft().getValue());
            doPreorder(tree.getLeft());
        }
        if (tree.getRight() != null) {
            result.append(tree.getRight().getValue());
            doPreorder(tree.getRight());
        }
    }
    
    public static void doInorder(Tree tree) {
        if (tree.getLeft() != null) doInorder(tree.getLeft());
        result.append(tree.getValue());
        if (tree.getRight() != null) doInorder(tree.getRight());
    }
    
    public static void doPostorder(Tree tree) {
        if (tree.getRight() != null) {
            result.append(tree.getRight().getValue());
            doPostorder(tree.getRight());
        }
        if (tree.getLeft() != null) {
            result.append(tree.getLeft().getValue());
            doPostorder(tree.getLeft());
        }
    }
}
class Tree {
    private final char value;
    private Tree left;
    private Tree right;

    public Tree(char value) {
        left = null;
        right = null;
        this.value = value;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    public char getValue() {
        return value;
    }

    public Tree getLeft() {
        return left;
    }

    public Tree getRight() {
        return right;
    }
}