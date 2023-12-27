class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String myColor = board[h][w];
        
        // 상
        if (h - 1 >= 0 && myColor.equals(board[h - 1][w])) answer++;
        // 하
        if (h + 1 < board.length && myColor.equals(board[h + 1][w])) answer++;
        // 좌
        if (w - 1 >= 0 && myColor.equals(board[h][w - 1])) answer++;
        // 우
        if (w + 1 < board[0].length && myColor.equals(board[h][w + 1])) answer++;
        
        return answer;
    }
}