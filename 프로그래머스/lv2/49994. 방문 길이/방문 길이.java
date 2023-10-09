import java.util.HashSet;

class Solution {
    HashSet<String> closedSet = new HashSet<>();
    StringBuilder curPosBuilder = new StringBuilder().append("0505");
    
    public int solution(String dirs) {
        char[] dirArr = dirs.toCharArray();
        
        for (char c : dirArr) {
            String pos = curPosBuilder.toString();
            switch (c) {
                case 'U':
                    move(pos, new int[] { 0, 1 });
                    break;
                case 'D':
                    move(pos, new int[] { 0, -1 });
                    break;
                case 'R':
                    move(pos, new int[] { 1, 0 });
                    break;
                case 'L':
                    move(pos, new int[] { -1, 0 });
                    break;
            }
        }
        
        return closedSet.size();
    }
    
    private void move(String curPosStr, int[] nextPos) {
        int curPos = Integer.parseInt(curPosStr);
        int[] curPosArr = new int[] { curPos / 100, curPos % 100 };
        
        nextPos[0] += curPosArr[0];
        nextPos[1] += curPosArr[1];
        
        if (nextPos[0] <= 10 && nextPos[1] <= 10 && nextPos[0] >= 0 && nextPos[1] >= 0) {
            String nextPosStr = new StringBuilder()
                .append(String.format("%02d", nextPos[0]))
                .append(String.format("%02d", nextPos[1])).toString();
            String next = new StringBuilder().append(curPosStr).append(nextPosStr).toString();
            String nextReversed = new StringBuilder().append(nextPosStr).append(curPosStr).toString();
            
            if (!closedSet.contains(nextReversed)) closedSet.add(next);
            curPosBuilder.setLength(0);
            curPosBuilder.append(nextPosStr);
        }
    }
}