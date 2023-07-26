import java.util.Arrays;

class Solution {
    int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        int[] one = Arrays.stream(arr)
                    .flatMapToInt(k -> Arrays.stream(k))
                    .distinct().toArray();
        if (one.length == 1) answer[one[0]]++;
        else doQuad(arr);
        
        return answer;
    }
    
    public void doQuad(int[][] arr) {
        final int aHalfLength = arr.length / 2;
        
        if (arr[0].length > 1) {
            int[][][] quadArrs = new int[4][aHalfLength][aHalfLength];
            int i = 0;
            int j = 0;
            
            for (int y = 0; y < aHalfLength; y++) {
                j = 0;
                for (int x = 0; x < aHalfLength; x++) {
                    quadArrs[0][i][j] = arr[y][x];
                    
                    quadArrs[2][i][j] = arr[y + aHalfLength][x];
                    j++;
                }
                i++;
            }
            i = 0;
            
            for (int y = aHalfLength; y < arr.length; y++) {
                j = 0;
                for (int x = aHalfLength; x < arr.length; x++) {
                    quadArrs[1][i][j] = arr[y - aHalfLength][x];
                    quadArrs[3][i][j] = arr[y][x];
                    j++;
                }
                i++;
            }
            
            for (int[][] quadArr : quadArrs) {
                int[] num = Arrays.stream(quadArr)
                    .flatMapToInt(k -> Arrays.stream(k))
                    .distinct().toArray();
                if (num.length == 1) answer[num[0]]++;
                else doQuad(quadArr);
            }
        }
        else {
            for (int[] a : arr)
                for (int i : a) answer[i]++;
        }
    }
}