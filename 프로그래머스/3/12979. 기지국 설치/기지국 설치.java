class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int station = stations[0];
        while (1 < station - w) {
            station -= 2 * w + 1;
            answer++;
        }
        
        int nextIdx = 1;
        station = stations[0];
        while (nextIdx < stations.length) {
            if (station + w + 1 < stations[nextIdx] - w) {
                station += 2 * w + 1;
                answer++;
            } else station = stations[nextIdx++];
        }
        
        while (station + w < n) {
            station += 2 * w + 1;
            answer++;
        }
        
        return answer;
    }
}