import java.util.Map;

class Solution {
    public int solution(String dartResult) {
        Map<Character, Integer> bonusMap = Map.of('S', 1, 'D', 2, 'T', 3, '*', 2, '#', -1);
        String[] scoreStr = dartResult.split("[SDT*#]+");  // 숫자만 추출
        int[] score = new int[3];
        String[] bonus;
        
        dartResult = dartResult.replaceFirst("\\d+", "");  // 맨 앞 숫자 제거
        bonus = dartResult.split("\\d+");  // 숫자를 제외한 나머지 문자열 추출
        for (int i = 0; i < 3; i++) {
            score[i] = Integer.parseInt(scoreStr[i]);
            score[i] = (int) Math.pow(score[i], bonusMap.get(bonus[i].charAt(0)));  // S, D, T 적용
            if (bonus[i].length() == 2) {  // *, # 있는 경우
                score[i] *= bonusMap.get(bonus[i].charAt(1));
                if (i > 0 && bonus[i].charAt(1) == '*') score[i - 1] *= bonusMap.get(bonus[i].charAt(1));
            }
        }
        return score[0] + score[1] + score[2];
    }
}