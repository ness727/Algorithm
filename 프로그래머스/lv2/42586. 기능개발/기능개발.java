import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] result = new int[progresses.length];
        int pre = 0, check = 0;
        
        while(check != progresses.length) {
            check = 0;
            for (int i = 0; i < progresses.length; i++) {
                if (progresses[i] < 100) {
                    progresses[i] += speeds[i];
                    if (progresses[i] >= 100) {
                        result[i] = 1;
                        check++;
                    }
                }
                else check++;
            }
            
            int count = 0;
            if (result[pre] == 1) {
                for (; pre < progresses.length; pre++) {
                    if (result[pre] != 1) break;
                    count++;
                }
                answer.add(count);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}