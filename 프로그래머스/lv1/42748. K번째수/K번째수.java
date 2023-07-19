import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        return Arrays.stream(commands)
            .mapToInt(c -> IntStream.rangeClosed(c[0], c[1])
                      .map(i -> array[i - 1])
                      .sorted()
                      .skip(c[2] - 1)
                      .min()
                      .getAsInt()
                     )
            .toArray();
    }
}