import java.util.Arrays;

class Solution {
    public int solution(int[] num_list) {
        return Arrays.stream(num_list).reduce((i, j) -> i * j).getAsInt()
            < Math.pow(Arrays.stream(num_list).reduce(Integer::sum).getAsInt(), 2)
            ? 1 : 0;
    }
}