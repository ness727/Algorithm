import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        // 2
        Arrays.sort(data, 
            Comparator.comparing((int[] arr) -> arr[col - 1])
                .thenComparing((int[] arr1, int[] arr2) -> arr2[0] - arr1[0]));
        
        // 3
        int count = row_end - row_begin + 1;
        int[] result = new int[count];
        for (int i = row_begin - 1; i < row_end; i++)
            for (int num : data[i])
                result[i - row_begin + 1] += num % (i + 1);
        
        // 4
        for (int n : result) answer ^= n;
        return answer;
    }
}