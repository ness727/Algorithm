import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        for (int i = citations.length; i >= 0; i--) {
            int count = 0;
            
            for (int j = citations.length - 1; j >= 0; j--) {
                if (citations[j] >= i) count = citations.length - j;
                else break;
            }
            if (count >= i) return i;
        }
        return 0;
    }
}