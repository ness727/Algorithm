import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> indexMap = new HashMap<>();
        int pre = 0, post = 1;
        
        for (int i = 65; i < 91; i++)
            indexMap.put(String.valueOf((char)i), i - 64);
        
        while (post < msg.length()) {
            if (!indexMap.containsKey(msg.substring(pre, post + 1))) {
                answer.add(indexMap.get(msg.substring(pre, post)));
                indexMap.put(msg.substring(pre, post + 1), indexMap.size() + 1);
                pre = post++;
            }
            else post++;
        }
        answer.add(indexMap.get(msg.substring(pre, post)));
        return answer.stream().mapToInt(i -> i).toArray();
    }
}