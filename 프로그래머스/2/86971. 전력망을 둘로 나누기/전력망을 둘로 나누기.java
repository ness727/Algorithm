import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    HashMap<Integer, ArrayList<Integer>> numMap = new HashMap<>();
    ArrayList<Integer> foundList = new ArrayList<>();
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < wires.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (!numMap.containsKey(wires[i][j])) {
                    ArrayList<Integer> linkedNodeList = new ArrayList<>();
                    linkedNodeList.add(wires[i][1 - j]);
                    numMap.put(wires[i][j], linkedNodeList);
                } else {
                    numMap.get(wires[i][j]).add(wires[i][1 - j]);
                }
            }
        }
        
        for (int i = 0; i < wires.length; i++) {
            foundList.clear();
            getCount(numMap.get(wires[i][0]), wires[i][1]);
            int result = foundList.size() == 0 ? 1 : foundList.size();
            answer = Math.min(answer, Math.abs(2 * result - n));
        }
        return answer;
    }
    
    public void getCount(ArrayList<Integer> linkedNodeList, Integer second) {
        for (Integer num : linkedNodeList) {
            if (num == second) continue;
            
            if (!foundList.contains(num)) {
                foundList.add(num);
                getCount(numMap.get(num), second);
            }
        }
    }
}