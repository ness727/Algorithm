class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] data = new int[rows][columns];
        
        int count = 1;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++) data[i][j] = count++;
        
        for (int i = 0; i < queries.length; i++) {
            int[] start = new int[] { queries[i][0] - 1, queries[i][1] - 1 };
            int[] end = new int[] { queries[i][2] - 1, queries[i][3] - 1 };
            
            int min = data[start[0]][start[1]];
            for (int y = start[0]; y < end[0]; y++) {
                min = Math.min(min, data[y + 1][start[1]]);
                int temp = data[y][start[1]];
                data[y][start[1]] = data[y + 1][start[1]];
                data[y + 1][start[1]] = temp;
            }
            for (int x = start[1]; x < end[1]; x++) {
                min = Math.min(min, data[end[0]][x + 1]);
                int temp = data[end[0]][x];
                data[end[0]][x] = data[end[0]][x + 1];
                data[end[0]][x + 1] = temp;
            }
            for (int y = end[0]; y > start[0]; y--) {
                min = Math.min(min, data[y - 1][end[1]]);
                int temp = data[y][end[1]];
                data[y][end[1]] = data[y - 1][end[1]];
                data[y - 1][end[1]] = temp;
            }
            for (int x = end[1]; x > start[1] + 1; x--) {
                min = Math.min(min, data[start[0]][x - 1]);
                int temp = data[start[0]][x];
                data[start[0]][x] = data[start[0]][x - 1];
                data[start[0]][x - 1] = temp;
            }
            answer[i] = min;
        }
        return answer;
    }
}