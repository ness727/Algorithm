class Solution {
    public int solution(int[][] sizes) {
        int hMax = 0;
        int vMax = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            int h = sizes[i][0];
            int v = sizes[i][1];
            
            if (h < v) {
                int temp = h;
                h = v;
                v = temp;
                sizes[i] = new int[] { v, h };
            }
            
            hMax = Math.max(hMax, h);
            vMax = Math.max(vMax, v);
        }
        return hMax * vMax;
    }
}