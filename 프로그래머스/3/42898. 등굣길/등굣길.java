class Solution {
    private static final int MOD = 1000000007;
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        
        map[0][0] = 1;
        for (int[] puddle : puddles) map[puddle[1] - 1][puddle[0] - 1] = -1;
        
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (map[y][x] == -1) continue;
                if (0 <= x - 1 && map[y][x - 1] != -1) map[y][x] += map[y][x - 1] % MOD;
                if (0 <= y - 1 && map[y - 1][x] != -1) map[y][x] += map[y - 1][x] % MOD;
            }
        }
        return map[n - 1][m - 1] % MOD;
    }
}