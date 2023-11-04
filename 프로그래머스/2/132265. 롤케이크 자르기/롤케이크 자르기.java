import java.util.Queue;
import java.util.HashSet;
import java.util.HashMap;
import java.util.LinkedList;

class Solution {
    public int solution(int[] topping) {
        HashMap<Integer, Queue<Integer>> toppingMap = new HashMap<>();
        HashSet<Integer> leftSet = new HashSet<>();
        HashSet<Integer> rightSet = new HashSet<>();
        int answer = 0;
        
        for (int i = 0; i < topping.length; i++) {
            if (!toppingMap.containsKey(topping[i])) {
                Queue<Integer> temp = new LinkedList<>();
                toppingMap.put(topping[i], temp);
                temp.add(i);
            }
            else toppingMap.get(topping[i]).add(i);
            rightSet.add(topping[i]);
        }
        
        for (int i = 0; i < topping.length; i++) {
            if (toppingMap.get(topping[i]).size() == 1) {
                rightSet.remove(topping[i]);
                leftSet.add(topping[i]);
                if (leftSet.size() == rightSet.size()) answer++;
            }
            else {
                toppingMap.get(topping[i]).poll();
                leftSet.add(topping[i]);
                if (leftSet.size() == rightSet.size()) answer++;
            }
        }
        
        return answer;
    }
}