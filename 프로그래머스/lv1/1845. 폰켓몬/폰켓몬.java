import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        return (int)Math.min(Arrays.stream(nums).distinct().count(), nums.length / 2);
    }
}