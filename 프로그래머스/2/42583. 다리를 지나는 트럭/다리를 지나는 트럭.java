import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> truckQueue = new LinkedList<>();
        HashMap<Integer, Integer> truckMap = new HashMap<>();
        int answer = 0;
        int curWeight = 0;
        
        for (int i = -1; i < truck_weights.length - 1;) {
            i++;
            answer++;
            
            // 이미 다리 위에 올라가 있는 트럭들 처리
            if (!truckQueue.isEmpty()) {
                // 다리를 지나고 있는 트럭 진행도 + 1
                for (Integer index : truckQueue) {
                    truckMap.put(index, truckMap.get(index) + 1);
                }
                // 다리를 지난 트럭이 있을 때 처리
                while (!truckQueue.isEmpty() 
                       && truckMap.get(truckQueue.peek()) > bridge_length) {
                    curWeight -= truck_weights[truckQueue.poll()];
                }
                
            }
            
            // 최대 길이보다 적은 수의 트럭이 올라가 있는지
            // 최대 무게보다 가벼울 때
            if (bridge_length <= truckQueue.size() 
                || weight - curWeight < truck_weights[i]) {
                i--;
                continue;
            }
            
            // 다리 위에 트럭 추가
            truckQueue.add(i);
            truckMap.put(i, 1);
            curWeight += truck_weights[i];
        }
        
        answer += ((truckQueue.size() != 0) 
                   ? bridge_length - truckMap.get(truck_weights.length - 1) + 1 : 0);
        return answer;
    }
}