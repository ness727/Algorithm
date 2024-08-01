import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

class Solution {
    private int groupId = 2;
    private ArrayList<int[]> resultList = new ArrayList<>();
    
    public int solution(int[][] land) {
        HashMap<Integer, Integer> groupSizeMap = new HashMap<>();
        HashSet<Integer> groupIdSet = new HashSet<>();
        int answer = 0;
        
        for (int n = 0; n < land.length; n++) {
            for (int m = 0; m < land[0].length; m++) {
                if (land[n][m] != 1) continue;
                resultList.clear();
                
                ArrayList<int[]> newLandList = new ArrayList<>();
                int[] curLand = new int[] { m, n };
                land[curLand[1]][curLand[0]] = groupId;
                newLandList.add(curLand);
                resultList.add(curLand);
                
                bfs(newLandList, land);
                
                groupSizeMap.put(groupId++, resultList.size());
            }
        }
        
        for (int m = 0; m < land[0].length; m++) {
            int sum = 0;
            groupIdSet.clear();
            for (int n = 0; n < land.length; n++) {
                if (land[n][m] > 1) groupIdSet.add(land[n][m]);
            }
            for (Integer gId : groupIdSet) sum += groupSizeMap.get(gId);
            answer = Math.max(answer, sum);
        }
        return answer;
    }
    
    private void bfs(ArrayList<int[]> curLandList, int[][] land) {       
        ArrayList<int[]> nextLandList = new ArrayList<>();
        
        for (int[] curLand : curLandList) {
            int m = curLand[0];
            int n = curLand[1];
            
            // 상
            if (0 <= n - 1) {
                int[] up = new int[] { m, n - 1 };
                if (land[up[1]][up[0]] == 1) {
                    land[up[1]][up[0]] = groupId;
                    nextLandList.add(up);
                    resultList.add(up);
                }
            }
            // 하
            if (n + 1 < land.length) {
                int[] down = new int[] { m, n + 1 };
                if (land[down[1]][down[0]] == 1) {
                    land[down[1]][down[0]] = groupId;
                    nextLandList.add(down);
                    resultList.add(down);
                }
            }
            // 좌
            if (0 <= m - 1) {
                int[] left = new int[] { m - 1, n };
                if (land[left[1]][left[0]] == 1) {
                    land[left[1]][left[0]] = groupId;
                    nextLandList.add(left);
                    resultList.add(left);
                }
            }
            // 우
            if (m + 1 < land[0].length) {
                int[] right = new int[] { m + 1, n };
                if (land[right[1]][right[0]] == 1) {
                    land[right[1]][right[0]] = groupId;
                    nextLandList.add(right);
                    resultList.add(right);
                }
            }
        }
        if (nextLandList.size() != 0) bfs(nextLandList, land);
    }
}