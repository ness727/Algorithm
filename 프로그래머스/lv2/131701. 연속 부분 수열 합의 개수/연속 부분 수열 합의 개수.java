import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        final int len = elements.length;
        HashSet<Integer> answerSet = new HashSet<>();
        int[] answer = new int[len];
        
        for (int i = 0; i < len; i++) {
            if (i == len - 1) break;
            for (int j = 0; j < len; j++) {
                answer[j] += elements[(j + i) % len];
                answerSet.add(answer[j]);
            }
        }
        return answerSet.size() + 1;
    }
}