import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int[] arr) {
        ArrayList<HashSet<Integer>> numList = new ArrayList<>();
        
        for (int i = 0; i < arr.length - 1; i++) {
            numList.clear();
            
            numList.add(new HashSet<Integer>());
            for (int j = 1 ; j <= Math.sqrt(arr[i]); j++) {
                if (arr[i] % j == 0) {
                    numList.get(0).add(j);
                    numList.get(0).add(arr[i] / j);
                }
            }
            
            numList.add(new HashSet<Integer>());
            for (int j = 1 ; j <= Math.sqrt(arr[i + 1]); j++) {
                if (arr[i + 1] % j == 0) {
                    numList.get(1).add(j);
                    numList.get(1).add(arr[i + 1] / j);
                }
            }
            
            numList.get(0).retainAll(numList.get(1));
            int g = Collections.max(numList.get(0));
            arr[i + 1] = arr[i] * arr[i + 1] / g;
        }
        return arr[arr.length - 1];
    }
}