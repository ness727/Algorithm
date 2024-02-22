import java.util.Arrays;
import java.util.stream.Stream;

class Solution {
    public int[] solution(int[] arr, int k) {
        return Stream.of(Arrays.stream(arr).distinct().limit(k).toArray(), 
                Arrays.stream("-1s".repeat(k).split("s")).mapToInt(Integer::parseInt).toArray() 
            )
            .flatMapToInt(Arrays::stream)
            .limit(k)
            .toArray();
    }
}