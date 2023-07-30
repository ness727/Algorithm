import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        ArrayList<Integer> kList = new ArrayList<>();
        
        for (int i = 0; i < score.length; i++) {
            kList.add(score[i]);
            int min = Collections.min(kList);
            if (i >= k) {
                if (score[i] > min) kList.remove(kList.indexOf(min));
                else kList.remove(kList.indexOf(score[i]));
            }
            answer[i] = Collections.min(kList);
        }
        return answer;
    }
}