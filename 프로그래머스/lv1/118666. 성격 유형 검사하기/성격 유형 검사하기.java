import java.util.stream.*;
import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String[] answer = new String[] {"RT", "CF", "JM", "AN"};
        int[] score = new int[] { 3, 2, 1, 0, 1, 2, 3 };
        HashMap<Character, Integer> surveyMap = new HashMap<>();
        
        for (int i = 0; i < survey.length; i++) {
            int select = 0;
            if (choices[i] <= 3) select = 0;
            else if (choices[i] >= 5) select = 1;
            else continue;
            Character c = survey[i].charAt(select);
            if (surveyMap.containsKey(c))
                surveyMap.put(c, surveyMap.get(c) + score[choices[i] - 1]);
            else surveyMap.put(c, score[choices[i] - 1]);
        }
        
        return Arrays.stream(answer)
            .map(i -> surveyMap.getOrDefault(i.charAt(0), 0) >= surveyMap.getOrDefault(i.charAt(1), 0) 
                ? String.valueOf(i.charAt(0)) : String.valueOf(i.charAt(1)))
            .collect(Collectors.joining());
    }
}