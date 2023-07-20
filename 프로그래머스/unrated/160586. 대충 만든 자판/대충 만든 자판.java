import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        /*HashMap<String, Integer> keyHashMap = new HashMap<>();
        
        for (String keymapStr : keymap) {
            for (int i = 0; i < keymapStr.length(); i++) {
                if (keyHashMap.containsKey(String.valueOf(keymapStr.charAt(i)))) {
                    if (keyHashMap.get(String.valueOf(keymapStr.charAt(i))) > i) 
                        keyHashMap.put(String.valueOf(keymapStr.charAt(i)), i);
                }
                else keyHashMap.put(String.valueOf(keymapStr.charAt(i)), i);
            }
        }
        
        for (int i = 0; i < targets.length; i++) {
            for (int j = 0; j < targets[i].length(); j++) {
                if (keyHashMap.containsKey(String.valueOf(targets[i].charAt(j)))) {
                    answer[i] += keyHashMap.get(String.valueOf(targets[i].charAt(j))) + 1;
                }
                else {
                    answer[i] = -1;
                    break;
                }
            }
        }
        */
        HashMap<Character, Integer> keyHashMap = new HashMap<>();
        
        for (String keymapStr : keymap) {
            for (int i = 0; i < keymapStr.length(); i++) {
                if (keyHashMap.containsKey(keymapStr.charAt(i))) {
                    if (keyHashMap.get(keymapStr.charAt(i)) > i) 
                        keyHashMap.put(keymapStr.charAt(i), i);
                }
                else keyHashMap.put(keymapStr.charAt(i), i);
            }
        }
        
        for (int i = 0; i < targets.length; i++) {
            for (int j = 0; j < targets[i].length(); j++) {
                if (keyHashMap.containsKey(targets[i].charAt(j))) {
                    answer[i] += keyHashMap.get(targets[i].charAt(j)) + 1;
                }
                else {
                    answer[i] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}