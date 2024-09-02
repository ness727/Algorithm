import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    ArrayList<String> wordList = new ArrayList<>();
    HashSet<String> check = new HashSet<>();
    
    public int solution(String begin, String target, String[] words) {
        return bfs(List.of(begin), words, target, 0);
    }
    
    private int bfs(List<String> prevList, String[] words, String target, int answer) {
        ArrayList<String> nextList = new ArrayList<>();
        
        for (String prev : prevList)  {
            for (int i = 0; i < prev.length(); i++) {  // 한 글짜씩 순회
                for (String word : words) {
                    if (check.contains(word)) continue;
                    
                    String regex = new StringBuilder(prev).replace(i, i + 1, ".").toString();
                    if (word.matches(regex) && !word.equals(prev)) {
                        if (word.equals(target)) return ++answer;
                        nextList.add(word);
                        check.add(word);
                    }
                }
            }
        }
        if (nextList.isEmpty()) return 0;
        else return bfs(nextList, words, target, answer + 1);
    }
}