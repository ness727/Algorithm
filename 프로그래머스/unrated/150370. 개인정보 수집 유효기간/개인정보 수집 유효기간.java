import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] dateArray = today.split("\\.");
        HashMap<String, Integer> termsMap = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();
        int count = 1;
        
        for (String term : terms) {
            String[] tempTerm = term.split(" ");
            termsMap.put(tempTerm[0], Integer.valueOf(tempTerm[1]));
        }
        
        for (String privacy : privacies) {
            String[] tempPrivacy =  privacy.split(" ");
            int termMonth = Integer.valueOf(termsMap.get(tempPrivacy[1]));
            String[] date = tempPrivacy[0].split("\\.");
            int monthToYear = 0;
            int month = Integer.valueOf(date[1]) + termMonth % 12;
            if (month > 12) {
                month -= 12;
                monthToYear = 1;
            }
            int year = Integer.valueOf(date[0]) + termMonth / 12 + monthToYear;
            int day = Integer.valueOf(date[2]);
            if(Integer.valueOf(dateArray[0]) * 12 * 28 + Integer.valueOf(dateArray[1]) * 28 
               + Integer.valueOf(dateArray[2]) >= year * 12 * 28 + month * 28 + day) answer.add(count);
            count++;
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}