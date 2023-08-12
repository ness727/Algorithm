class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] numX = new int[10];
        int[] numY = new int[10];
        
        X.chars().forEach(i -> numX[Character.getNumericValue(i)]++);
        Y.chars().forEach(i -> numY[Character.getNumericValue(i)]++);
        for (int i = 9; i >= 0; i--) {
                for (int j = 0; j < Math.min(numX[i], numY[i]); j++)
                    answer.append(String.valueOf(i));
        }
        if (answer.length() > 0) {
            if (answer.charAt(0) == '0') return "0";
            else return answer.toString();
        }
        else return "-1";
    }
}