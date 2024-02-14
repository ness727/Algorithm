class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        
        for (String key : keyinput) {
            int width = (board[0] - 1) / 2, height = (board[1] - 1) / 2;
            switch (key) {
                case "left":
                    answer[0] = Math.max(answer[0] - 1, -width);
                    break;
                case "right":
                    answer[0] = Math.min(answer[0] + 1, width);
                    break;
                case "up":
                    answer[1] = Math.min(answer[1] + 1, height);
                    break;
                case "down":
                    answer[1] = Math.max(answer[1] - 1, -height);
            }
        }
        return answer;
    }
}