class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String myColor = board[h][w];
        
        if (h - 1 >= 0) {  // 상
            if (myColor.equals(board[h - 1][w])) answer++;
        }
        if (h + 1 < board.length) {  // 하
            if (myColor.equals(board[h + 1][w])) answer++;
        }
        if (w - 1 >= 0) {  // 좌
            if (myColor.equals(board[h][w - 1])) answer++;
        }
        if (w + 1 < board[0].length) {  // 우
            if (myColor.equals(board[h][w + 1])) answer++;
        }
        
        return answer;
    }
}