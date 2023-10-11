import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    int answer = 0;
    HashMap<Integer, Node> nodeMap = new HashMap<>();
    ArrayList<Node> closedList = new ArrayList<>();
    
    public int solution(int n, int[][] computers) {
        for (int i = 0; i < computers.length; i++) {
            nodeMap.put(i, new Node());
        }
        
        for (int i = 0; i < computers.length; i++) {
            nodeMap.get(i).setconnectedList(i, computers[i]);
        }
        
        for (int i = 0; i < computers.length; i++) {
            if (!closedList.contains(nodeMap.get(i))) {
                doDfs(nodeMap.get(i));
                answer++;
            }
        }
        return answer;
    }
    
    public void doDfs(Node node) {
        closedList.add(node);
        
        for (Node n : node.getConnectedList()) {
            if (!closedList.contains(n)) {
                doDfs(n);
            }
        }
    }
    
    class Node {
        ArrayList<Node> connectedList = new ArrayList<>();
        
        public void setconnectedList(int currentComputer, int[] computerArr) {
            for (int i = 0; i < computerArr.length; i++) {
                if (i != currentComputer && computerArr[i] == 1) {
                    connectedList.add(nodeMap.get(i));
                }
            }
        }
        
        public ArrayList<Node> getConnectedList() {
            return connectedList;
        }
    }
}