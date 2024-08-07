import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int storey) {
        int answer = Integer.MAX_VALUE;
        ArrayList<int[]> resultList = getAnswer(List.of(new int[] { storey, 0 }),
                                                String.valueOf(storey).length());
        for (int[] i : resultList) answer = Math.min(answer, i[1]);
        return answer;
    }
    
    private ArrayList<int[]> getAnswer(List<int[]> storeyList, int count) {
        ArrayList<int[]> nextList = new ArrayList<>();
        
        for (int[] i : storeyList) {
            int curNum = i[0] % 10;
            int next = i[0] / 10;
            int[] new1 = new int[] { next + 1, i[1] + 10 - curNum };
            int[] new2 = new int[] { next, i[1] + curNum };
            nextList.add(new1);
            nextList.add(new2);
        }
        if (count-- == 0) return nextList;
        else return getAnswer(nextList, count);
    }
}