import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[][] solution(int[][] arr) {
        return IntStream.range(0, Math.max(arr.length, arr[0].length))
            .mapToObj(i -> {
                if (arr[0].length < arr.length) {
                    return Arrays.copyOf(arr[i], arr.length);
                } else if (arr[0].length > arr.length) {
                    if (i < arr.length) {
                        return Arrays.copyOf(arr[i], arr[0].length);
                    } else {
                        return new int[arr[0].length];
                    }
                } else return arr[i];
            })
            .toArray(int[][]::new);
    }
}