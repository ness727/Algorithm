import java.util.HashSet;

class Solution {
    HashSet<Integer> openSet = new HashSet<>();
    HashSet<Integer> closedSet = new HashSet<>();
    HashSet<Integer> newOpenSet;
    
    public int solution(int[][] maps) {
        openSet.add(0);  // 출발지
        return doBfs(maps, 1);
    }
    
    public int doBfs(int[][] maps, int answer) {
        newOpenSet = new HashSet<>();
        int count = 0;
        
        for (Integer openPos : openSet) {
            int x = openPos / 1000;
            int y = openPos % 1000;
            
            // 목적지 도착
            if (x == maps[0].length - 1 && y == maps.length - 1) {
                return answer;
            }
            
            if (y + 1 < maps.length) {  // 상
                if (!closedSet.contains(x * 1000 + (y + 1)) && maps[y + 1][x] != 0) {
                    newOpenSet.add(x * 1000 + (y + 1));
                    count++;
                }
            }
            if (y - 1 >= 0) {  // 하
                if (!closedSet.contains(x * 1000 + (y - 1)) && maps[y - 1][x] != 0) {
                    newOpenSet.add(x * 1000 + (y - 1));
                    count++;
                }
            }
            if (x - 1 >= 0) {  // 좌
                if (!closedSet.contains((x - 1) * 1000 + y) && maps[y][x - 1] != 0) {
                    newOpenSet.add((x - 1) * 1000 + y);
                    count++;
                }
            }
            if (x + 1 < maps[0].length) {  // 우
                if (!closedSet.contains((x + 1) * 1000 + y) && maps[y][x + 1] != 0) {
                    newOpenSet.add((x + 1) * 1000 + y);
                    count++;
                }
            }
            closedSet.add(openPos);
        }
        openSet = newOpenSet;
        if (count == 0) return -1;
        else return doBfs(maps, answer + 1);
    }
}