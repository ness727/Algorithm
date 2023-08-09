import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String[] strNum = s.split(" ");
        int[] intNum = new int[strNum.length];
            
        for (int i = 0; i < intNum.length; i++) intNum[i] = Integer.valueOf(strNum[i]);
        Arrays.sort(intNum);
        return intNum[0] + " " + intNum[intNum.length - 1];
    }
}