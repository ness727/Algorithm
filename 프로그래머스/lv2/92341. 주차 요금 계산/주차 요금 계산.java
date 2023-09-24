import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, int[]> recordMap = new HashMap<>();
        HashMap<Integer, Integer> result = new HashMap<>();
        final int endOfDay = 23 * 60 + 59;
        
        for (int i = 0; i < records.length; i++) {
            String[] car = records[i].split(" ");
            
            String[] timeStr = car[0].split(":");
            int time = Integer.parseInt(timeStr[0]) * 60 + Integer.parseInt(timeStr[1]);
            
            if (recordMap.containsKey(car[1])) {  // 출차
                time -= recordMap.get(car[1])[0];
                result.put(Integer.valueOf(car[1]), result.getOrDefault(Integer.valueOf(car[1]), 0) + time);
                recordMap.remove(car[1]);
            }
            else {  // 입차
                recordMap.put(car[1], new int[] { time });
            }
        }
        
        for (Map.Entry<String, int[]> remainCar : recordMap.entrySet()) // 마지막까지 나가지 않은 차 처리
            result.put(Integer.valueOf(remainCar.getKey())
                       , result.getOrDefault(Integer.valueOf(remainCar.getKey()), 0) + endOfDay - remainCar.getValue()[0]);
        
        for (Map.Entry<Integer, Integer> car : result.entrySet()) {  // 주차 요금 계산
            int fee = fees[1];
            
            if (car.getValue() > fees[0]) {
                fee += (car.getValue() - fees[0]) / fees[2] * fees[3];
                if ((car.getValue() - fees[0]) % fees[2] != 0) fee += fees[3];
            }
            
            result.put(Integer.valueOf(car.getKey()), fee);
            answer.add(Integer.valueOf(car.getKey()));
        }
        return answer.stream().sorted().mapToInt(i -> result.get(i)).toArray();
    }
}