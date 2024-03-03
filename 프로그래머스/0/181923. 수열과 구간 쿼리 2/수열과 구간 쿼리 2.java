import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        return Arrays.stream(queries)
            .mapToInt(q -> 
                 Arrays.stream(Arrays.copyOfRange(arr, q[0], q[1] + 1))
                    .filter(i -> i > q[2])
                    .min()
                    .orElse(-1)
            ).toArray();
    }
}