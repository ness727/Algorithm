import java.util.Arrays;

class Solution {
    public int solution(int[][] dots) {
        return Math.abs(Arrays.stream(dots).map(d -> d[0]).distinct().reduce((i, j) -> i - j).get() 
            * Arrays.stream(dots).map(d -> d[1]).distinct().reduce((i, j) -> i - j).get());
    }
}