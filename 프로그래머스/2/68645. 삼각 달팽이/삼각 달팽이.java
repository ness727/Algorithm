class Solution {
    public int[] solution(int n) {
        int[] answer = new int[(1 + n) * n / 2];
        int tempN = n;
        
        int[][] nums = new int[n][];       
        for (int i = 0; i < n; i++) nums[i] = new int[i + 1];
        
        int[][] start = new int[3][];
        start[0] = new int[] { 0, 0 };
        start[1] = new int[] { n - 1, 1 };
        start[2] = new int[] { n - 2, n - 2 };
        
        int count = 1;
        int check = 0;
        while (n != 0) {
            check %= 3;
            for (int i = 0; i < n; i++) {
                switch (check) {
                    case 0:
                        nums[start[0][0] + i][start[0][1]] = count++;
                        break;
                    case 1:
                        nums[start[1][0]][start[1][1] + i] = count++;
                        break;
                    case 2:
                        nums[start[2][0] - i][start[2][1] - i] = count++;
                }
            }
            switch (check) {
                    case 0:
                        start[0][0] += 2;
                        start[0][1] += 1;
                        break;
                    case 1:
                        start[1][0] -= 1;
                        start[1][1] += 1;
                        break;
                    case 2:
                        start[2][0] -= 1;
                        start[2][1] -= 2;
            }
            check++;
            n--;
        }
        
        int index = 0;
        for (int i = 0; i < tempN; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                answer[index++] = nums[i][j];
            }
        }
        
        return answer;
    }
}