import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    HashMap<String, String> nodeMap;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for (int i = 0; i < places.length; i++) {
            answer[i] = 1;
            String[] roomArr = places[i];
            nodeMap = new HashMap<>();
            ArrayList<String> pList = new ArrayList<>();

            for (int y = 0; y < 5; y++) {
                for (int x = 0; x < 5; x++) {
                    String yx = y + "" + x;
                    String subStr = roomArr[y].substring(x, x + 1);
                    nodeMap.put(yx, subStr);
                    if (subStr.equals("P")) pList.add(yx);
                }
            }
            for (String pYx : pList) answer[i] = Math.min(answer[i], check(pYx));
        }
        return answer;
    }
    
    private int check(String pYx) {
        Integer yx = Integer.parseInt(pYx);
        Integer y = yx / 10, x = yx % 10;
        StringBuilder result = new StringBuilder();
        int[][] checkArr = new int[][] { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 },  // 상하좌우
                                         { 1, 0, 1, 0 }, { 1, 0, 0, -1 }, { 1, 0, 0, 1 },  // 상
                                         { -1, 0, -1, 0 }, { -1, 0, 0, -1 }, { -1, 0, 0, 1 },  // 하
                                         { 0, -1, 1, 0 }, { 0, -1, -1, 0 }, { 0, -1, 0, -1 },  // 좌
                                         { 0, 1, 1, 0 }, { 0, 1, -1, 0 }, { 0, 1, 0, 1 } };  // 우
        
        for (int i = 0; i < checkArr.length; i++) {
            result.setLength(0);
            result.append("P");
            int tempY = y, tempX = x;
            for (int j = 0; j < checkArr[i].length; j += 2) {
                tempY += checkArr[i][j];
                tempX += checkArr[i][j + 1];
                result.append(nodeMap.getOrDefault(String.valueOf(tempY + "" + tempX), ""));
            }
            String strResult = result.toString();
            if (strResult.equals("PP") || strResult.equals("POP")) return 0;
        }
        return 1;
    }
}