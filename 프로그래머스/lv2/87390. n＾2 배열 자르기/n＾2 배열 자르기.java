import java.util.ArrayList;

class Solution {
    public int[] solution(int n, long left, long right) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] leftIndex = { (int)(left / n), (int)(left % n) };
        int[] rightIndex = { (int)(right / n), (int)(right % n) };
        
        for (int i = leftIndex[0]; i <= rightIndex[0]; i++) {
            if (leftIndex[0] == rightIndex[0]) {
                for (int j = leftIndex[1]; j <= rightIndex[1]; j++)
                    answer.add(Math.max(i, j) + 1);
            }
            else if (i == leftIndex[0]) {
                for (int j = leftIndex[1]; j < n; j++) answer.add(Math.max(i, j) + 1);
            }
            else if (i == rightIndex[0]) {
                for (int j = 0; j <= rightIndex[1]; j++) answer.add(Math.max(i, j) + 1);
            }
            else {
                for (int j = 0; j < n; j++) answer.add(Math.max(i, j) + 1);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}