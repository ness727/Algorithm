class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        int[] startPos = new int[] { wallpaper.length, wallpaper[0].length() };
        int[] endPos = new int[]  { 0, 0 };
        
        for (int j = 0; j < wallpaper.length; j++) {
            for (int i = 0; i < wallpaper[j].length(); i++) {
                if (wallpaper[j].charAt(i) == '#') {
                    if (j < startPos[0]) startPos[0] = j;
                    if (i < startPos[1]) startPos[1] = i;
                    if (j > endPos[0]) endPos[0] = j;
                    if (i > endPos[1]) endPos[1] = i;
                }
            }
        }
        answer = new int[] {startPos[0], startPos[1], endPos[0] + 1, endPos[1] + 1};
        return answer;
    }
}