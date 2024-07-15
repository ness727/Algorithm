class Solution {
    public int solution(String[] board) {        
        int[] count = getCount(board);
        boolean[] winner = checkWinner(board);
        
        // 정상 흐름인 경우
        if (winner[0] && !winner[1]) {
            if (count[0] - count[1] == 1) return 1;
        } else if (!winner[0] && winner[1]) {
            if (count[0] == count[1]) return 1;
        } else if (!winner[0] && !winner[1]) {
            if ((count[0] >= count[1]) && (count[0] - count[1] < 2)) return 1;
        }
        return 0;
    }
    
    // X가 O보다 많거나 둘의 개수 차이가 2 이상일 때
    private int[] getCount(String[] board) {
        int[] count = new int[2];
        
        for (String b : board) {
            for (Character c : b.toCharArray()) {
                if (c == 'O') count[0]++;
                else if (c == 'X') count[1]++;
            }
        }
        return count;
    }
    
    // 승자 확인
    private boolean[] checkWinner(String[] board) {
        boolean[] winner = new boolean[2];
        String boardStr = board[0] + board[1] + board[2];
        int[][] winArr = new int[][] {
            { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 },  // 가로
            { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 },  // 세로
            { 0, 4, 8 }, { 2, 4, 6 }  // 대각선
        };
        
        for (int i = 0; i < winArr.length; i++) {
            char[] select = new char[] { 
                boardStr.charAt(winArr[i][0]), 
                boardStr.charAt(winArr[i][1]), 
                boardStr.charAt(winArr[i][2])
            };
            
            if (select[0] == select[1] && select[1] == select[2]) {
                if (select[0] == 'O') winner[0] = true;
                if (select[0] == 'X') winner[1] = true;
            } 
        }
        return winner;
    }
}