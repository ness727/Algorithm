import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        ArrayList<Integer> bombList = new ArrayList<>();
        HashSet<Integer> result = new HashSet<>();
        
        for (int y = 0; y < board.length; y++)
            for (int x = 0; x < board[y].length; x++)
                if (board[y][x] == 1) bombList.add(x * 1000 + y);
        
        for (Integer pos : bombList) {
            int x = pos / 1000, y = pos % 1000;
            
            for (int i = y - 1; i <= y + 1; i++) {
                for (int j = x - 1; j <= x + 1; j++) {
                    if (i == board.length || i == -1 
                        || j == board.length || j == -1) continue;
                    result.add(j * 1000 + i);
                }
            }
        }
        answer = board.length * board.length - result.size();
        return answer < 0 ? 0 : answer;
    }
}