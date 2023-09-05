class Solution {
    public int solution(int[] common) {
        return common[2] - common[1] == common[1] - common[0]
            ? 2 * common[common.length - 1] - common[common.length - 2] 
            : (int)Math.pow(common[common.length - 1], 2) / common[common.length - 2];
    }
}