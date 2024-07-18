import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    private HashMap<Integer, Node> nodeMap = new HashMap<>();
    private int sum;
    
    public int[] solution(String[] maps) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int y = 1;
        for (String map : maps) {
            int x = 1;
            for (char c : map.toCharArray()) {
                if (c == 'X') {
                    nodeMap.put(x * 1000 + y, null);
                } else {
                    int xy = x * 1000 + y;
                    int days = Character.getNumericValue(c);
                    nodeMap.put(xy, new Node(xy, days));
                }
                x++;
            }
            y++;
        }
        
        for (Map.Entry<Integer, Node> node : nodeMap.entrySet()) {
            if (node.getValue() != null) {
                // 상
                Node up = nodeMap.getOrDefault(node.getKey() + 1, null);
                if (up != null) {
                    node.getValue().getLinkedNodeList().add(up);
                }

                // 하
                Node down = nodeMap.getOrDefault(node.getKey() - 1, null);
                if (down != null) {
                    node.getValue().getLinkedNodeList().add(down);
                }

                // 좌
                Node left = nodeMap.getOrDefault(node.getKey() - 1000, null);
                if (left != null) {
                    node.getValue().getLinkedNodeList().add(left);
                }

                // 우
                Node right = nodeMap.getOrDefault(node.getKey() + 1000, null);
                if (right != null) {
                    node.getValue().getLinkedNodeList().add(right);
                }
            }
        }
        
        for (Map.Entry<Integer, Node> nodeEntry : nodeMap.entrySet()) {
            if (nodeEntry.getValue() != null && !nodeEntry.getValue().getIsMarked()) {
                sum = nodeEntry.getValue().getDays();
                nodeEntry.getValue().setIsMarked(true);
                bfs(nodeEntry.getValue().getLinkedNodeList());
                answer.add(sum);
            }
        }
        
        int[] answerArr = answer.stream().mapToInt(i -> i).sorted().toArray();
        return answerArr.length == 0 ? new int[] { -1 } : answerArr;
    }
    
    private void bfs(ArrayList<Node> linkedNodeList) {
        ArrayList<Node> nextNodeList = new ArrayList<>();
        
        for (int i = 0; i < linkedNodeList.size(); i++) {
            Node tempNode = linkedNodeList.get(i);
            
            if (!tempNode.getIsMarked()) {
                sum += tempNode.getDays();
                tempNode.setIsMarked(true);
                nextNodeList.addAll(tempNode.getLinkedNodeList());
            }
        }
        if (nextNodeList.size() != 0) bfs(nextNodeList);
    }
}

class Node {
    private int xy;
    private int days;
    private boolean isMarked = false;
    private ArrayList<Node> linkedNodeList = new ArrayList<>();
    
    public Node(int xy, int days) {
        this.xy = xy;
        this.days = days;
    }
    
    public int getXy() {
        return xy;
    }
    
    public int getDays() {
        return days;
    }
    
    public boolean getIsMarked() {
        return this.isMarked;
    }
    
    public ArrayList<Node> getLinkedNodeList() {
        return linkedNodeList;
    }
    
    public void setIsMarked(boolean isMarked) {
        this.isMarked = isMarked;
    }
}