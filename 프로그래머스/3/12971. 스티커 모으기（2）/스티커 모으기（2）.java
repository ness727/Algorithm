class Solution {
    public int solution(int sticker[]) {
        if (sticker.length == 1) return sticker[0];
        else if (sticker.length == 2) return Math.max(sticker[0], sticker[1]);
        
        int[] result0 = new int[sticker.length];
        int[] result1 = new int[sticker.length];
        
        result0[0] = sticker[0];
        if (sticker.length > 3) result0[2] = result0[0] + sticker[2];
        for (int i = 3; i < sticker.length - 1; i++) {
            result0[i] = Math.max(result0[i - 2], result0[i - 3]) + sticker[i];
        }
        
        result1[1] = sticker[1];
        result1[2] = sticker[2];
        for (int i = 3; i < sticker.length; i++) {
            result1[i] = Math.max(result1[i - 2], result1[i - 3]) + sticker[i];
        }
        
        return Math.max(
            Math.max(result0[result0.length - 3], result0[result0.length - 2]),
            Math.max(result1[result1.length - 2], result1[result1.length - 1]));
    }
}