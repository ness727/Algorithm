class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        int index = 0;
        StringBuilder iString = new StringBuilder();
        
        for (int i = 0; i < ingredient.length; i++) {
            iString.append(ingredient[i]);
            if (iString.length() >= 4) {
                int length = iString.length();
                if (iString.indexOf("1231", length - 4) != -1) {
                    iString.replace(length - 4, length, "");
                    answer++;
                    index = iString.indexOf("1231");
                    if (index != -1) {
                        iString.replace(index, index + 4, "");
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}