import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public int solution(String[][] book_time) {
        HashMap<Integer, Integer> roomMap = new HashMap<>();
        
        Arrays.sort(book_time, 
            (arr1, arr2) ->  
                Integer.parseInt(arr1[0].replaceFirst(":", "")) 
                - Integer.parseInt(arr2[0].replaceFirst(":", ""))
        );
        
        for (String[] time : book_time) {
            int checkInTime = Integer.parseInt(time[0].replaceFirst(":", ""));
            int checkOutTime = Integer.parseInt(time[1].replaceFirst(":", ""));
            
            for (int i = 0; i < roomMap.size() + 1; i++) {
                int prevTime = roomMap.getOrDefault(i, -1);
                
                if (prevTime <= checkInTime) {
                    roomMap.put(i, (checkOutTime % 100 >= 50) ? checkOutTime + 50 : checkOutTime + 10);
                    break;
                }
            }
        }
        return roomMap.size();
    }
}