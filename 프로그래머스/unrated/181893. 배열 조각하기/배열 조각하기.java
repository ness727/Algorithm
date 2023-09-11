import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        int[] result = new int[] { 0, arr.length - 1 };
        
        for (int i = 0; i < query.length; i++) {
            int length = result[1] - result[0];
            
            if (i % 2 == 0) result[1] -= (length - query[i]);
            else result[0] += query[i];
        }
        return Arrays.copyOfRange(arr, result[0], result[1] + 1);
    }
}