class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] babblingArr = new String[] {"aya", "ye", "woo", "ma"};
        
        for (int i = 0; i < babbling.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (babbling[i].contains(babblingArr[j])) {
                    babbling[i] = babbling[i].replace(babblingArr[j], String.valueOf(j));
                }
            }
            if (babbling[i].matches("^[0-9]*$") 
                && !babbling[i].contains("00") && !babbling[i].contains("11")
                && !babbling[i].contains("22") && !babbling[i].contains("33")) answer++;
        }
        
        return answer;
    }
}