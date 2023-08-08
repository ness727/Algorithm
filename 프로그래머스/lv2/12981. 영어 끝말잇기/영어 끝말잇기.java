import java.util.ArrayList;

class Solution {
    public int[] solution(int n, String[] words) {
        ArrayList<String> wordList = new ArrayList<>();
        
        for (int i = 0; i < words.length; i += n) {
            for (int j = i; j < (i + n > words.length ? words.length : i + n); j++) {
                if (j != 0) 
                    if (words[j].charAt(0) != words[j - 1].charAt(words[j - 1].length() - 1))
                        return new int[] { j % n + 1, i / n + 1 };
                
                if (!wordList.contains(words[j])) wordList.add(words[j]);
                else return new int[] { j % n + 1, i / n + 1 };
            }
        }
        return new int[] { 0, 0 };
    }
}