import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String str1, String str2) {
        HashMap<String, Integer> str1Map = new HashMap<>();
        HashMap<String, Integer> str2Map = new HashMap<>();
        
        for (int i = 0; i < str1.length() - 1; i++) {
            String temp = str1.substring(i, i + 2).toLowerCase();
            if (temp.matches("[a-z]+")) {
                str1Map.put(temp, str1Map.getOrDefault(temp, 0) + 1);
            }
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            String temp = str2.substring(i, i + 2).toLowerCase();
            if (temp.matches("[a-z]+")) {
                str2Map.put(temp, str2Map.getOrDefault(temp, 0) + 1);
            }
        }
        
        int inter = 0, union = 0;
        
        for (Map.Entry<String, Integer> entry : str1Map.entrySet()) {
            if (str2Map.containsKey(entry.getKey())) {
                inter += Math.min(entry.getValue(), str2Map.get(entry.getKey()));
                union += Math.max(entry.getValue(), str2Map.get(entry.getKey()));
            }
            else union += entry.getValue();
        }
        for (Map.Entry<String, Integer> entry : str2Map.entrySet()) {
            if (!str1Map.containsKey(entry.getKey())) 
                union += entry.getValue();
        }
        return union == 0 ? 65536 : (int)Math.floor((double)inter / union * 65536);
    }
}