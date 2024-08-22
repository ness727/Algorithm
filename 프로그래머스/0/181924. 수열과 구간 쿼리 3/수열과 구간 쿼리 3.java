import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        Arrays.stream(queries)
            .forEach(q -> {
                int temp = arr[q[0]];
                arr[q[0]] = arr[q[1]];
                arr[q[1]] = temp;
            });
        return arr;
    }
}