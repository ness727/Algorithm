import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        HashMap<Integer, Node> nodeMap = new HashMap<>();
        Node newNode = null;
        
        for (int[] edge : edges) {
            Node out, in;
            
            if (!nodeMap.containsKey(edge[0])) {
                out = new Node(edge[0]);
                nodeMap.put(edge[0], out);
            } else out = nodeMap.get(edge[0]);
            
            if (!nodeMap.containsKey(edge[1])) {
                in = new Node(edge[1]);
                nodeMap.put(edge[1], in);
            } else in = nodeMap.get(edge[1]);
            
            out.getOutList().add(in);
            in.getInList().add(out);
        }
        
        for (Node node : nodeMap.values()) {
            if (node.getOutList().size() > 1 
                && node.getInList().size() == 0) {
                newNode = node;
                answer[0] = newNode.getNum();
            }
        }
        
        for (Node linkedNode : newNode.getOutList()) {
            Node next = linkedNode;
            next.getInList().remove(newNode);
            
            while (true) {
                if (next.getOutList().size() == 0) {
                    answer[2]++;
                    break;
                } else if (next.getInList().size() == 2) {
                    answer[3]++;
                    break;
                }
                next = next.getOutList().get(0);
                if (next == linkedNode) {
                    answer[1]++;
                    break;
                }
            }
        }
        
        return answer;
    }
    
    static class Node {
        private int num;
        private ArrayList<Node> outList = new ArrayList<>();
        private ArrayList<Node> inList = new ArrayList<>();
        
        public Node(int num) { this.num = num; }
        
        public int getNum() { return num; }
        public ArrayList<Node> getOutList() { return outList; }
        public ArrayList<Node> getInList() { return inList; }
    }
}