import java.util.ArrayList;

class Solution {
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        ArrayList<int[]> dungeonList = new ArrayList<>();
        
        for (int[] dungeon : dungeons) dungeonList.add(dungeon);
        checkDungeons(k, dungeonList, 0);
        return answer;
    }
    
    public void checkDungeons(int k, ArrayList<int[]> dungeonList, int count) {
        for (int[] d : dungeonList) {
            if (k >= d[0]) {
                ArrayList<int[]> nextList = new ArrayList<>();
                
                for (int[] tempD : dungeonList)
                    if (tempD != d) nextList.add(tempD);
                checkDungeons(k - d[1], nextList, count + 1);
            }
        }
        answer = Math.max(count, answer);
    }
}