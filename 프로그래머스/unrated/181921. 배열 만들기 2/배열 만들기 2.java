import java.util.ArrayList;

class Solution {
    ArrayList<Integer> result = new ArrayList<>();
    
    public int[] solution(int l, int r) {
        doDfs(5, l, r);
        return result.size() == 0 
            ? new int[] { -1 } : result.stream().sorted().mapToInt(i -> i).toArray();
    }
    
    private void doDfs(int num, int l, int r) {
        if (num <= r) {
            if (num >= l) result.add(num);
            doDfs(num * 10, l, r);
            doDfs(num * 10 + 5, l, r);
        }
    }
}