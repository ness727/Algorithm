import java.util.HashMap;

class Solution {
    int answer = 123456789;
    char[][] result;
    HashMap<Integer, Integer> visitedMap = new HashMap<>();
    
    public int solution(String[] board) {
        result = new char[board.length][board[0].length()];
        int[] startPos = null;
        
        for (int i = 0; i < result.length; i++) {
            result[result.length - 1 - i] = board[i].toCharArray();
            if (startPos == null) {
                for (int j = 0; j < result[i].length; j++)
                    if (result[result.length - 1 - i][j] == 'R') 
                        startPos = new int[] { j, result.length - 1 - i };
            }   
        }
        move(startPos[0], startPos[1], 0);
        return answer != 123456789 ? answer : -1;
    }
    
    public void move(int x, int y, int count) {
        int key = x * 1000 + y;
        int tempX = x, tempY = y;
        
        if (result[y][x] == 'G') {
            if (answer > count) answer = count;
            return;
        }
        
        if (visitedMap.containsKey(key)) {
            if (visitedMap.get(key) > count) visitedMap.put(key, count);
            else return;
        }
        else visitedMap.put(key, count);
        
        while (true) {  // 상
            if (tempY + 1 == result.length) {
                move(tempX, tempY, count + 1);
                break;
            }
            else {
                if (result[tempY + 1][tempX] == 'D') {
                    move(tempX, tempY, count + 1);
                    break;
                }
                tempY++;
            }
        }
        
        tempY = y;
        while (true) {  // 하
            if (tempY - 1 < 0) {
                move(tempX, tempY, count + 1);
                break;
            }
            else {
                if (result[tempY - 1][tempX] == 'D') {
                    move(tempX, tempY, count + 1);
                    break;
                }
                tempY--;
            }
        }
        
        tempY = y;
        while (true) {  // 좌
            if (tempX - 1 < 0) {
                move(tempX, tempY, count + 1);
                break;
            }
            else {
                if (result[tempY][tempX - 1] == 'D') {
                    move(tempX, tempY, count + 1);
                    break;
                }
                tempX--;
            } 
        }
        
        tempX = x;
        while (true) {  // 우
            if (tempX + 1 == result[tempY].length) {
                move(tempX, tempY, count + 1);
                break;
            }
            else {
                if (result[tempY][tempX + 1] == 'D') {
                    move(tempX, tempY, count + 1);
                    break;
                }
                tempX++;
            }
        }
    }
}