class Solution {
    public int solution(int[] money) {
        int[][] result = new int[3][];
        int[] max = new int[3];
        
        for (int i = 0; i < 3; i++) {
            result[i] = new int[money.length];
            result[i][i] = money[i];
            if (i + 2 < money.length) result[i][i + 2] = money[i] + money[i + 2];
            if (i + 3 < money.length) result[i][i + 3] = money[i] + money[i + 3];
        }
        
        for (int i = 0; i < money.length; i++) {
            if (result[0][i] != 0) {
                if (i + 2 < money.length) {
                    if (i + 2 != money.length - 1) {
                        result[0][i + 2] = Math.max(result[0][i] + money[i + 2], result[0][i + 2]);
                        max[0] = Math.max(result[0][i + 2], max[0]);
                    }
                }
                if (i + 3 < money.length) {
                    if (i + 3 != money.length - 1) {
                        result[0][i + 3] = Math.max(result[0][i] + money[i + 3], result[0][i + 3]);
                        max[0] = Math.max(result[0][i + 3], max[0]);
                    }
                }
            }
            
            for (int j = 1; j < 3; j++) {
                if (result[j][i] != 0) {
                    if (i + 2 < money.length) {
                        result[j][i + 2] = Math.max(result[j][i] + money[i + 2], result[j][i + 2]);
                        max[j] = Math.max(result[j][i + 2], max[j]);
                    }
                    if (i + 3 < money.length) {
                        result[j][i + 3] = Math.max(result[j][i] + money[i + 3], result[j][i + 3]);
                        max[j] = Math.max(result[j][i + 3], max[j]);
                    }
                }
            }
        }

        return Math.max(max[0], Math.max(max[1], max[2]));
    }
}