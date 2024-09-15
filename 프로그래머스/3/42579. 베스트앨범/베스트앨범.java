import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Comparator;

import static java.util.Map.Entry;
import static java.util.AbstractMap.SimpleEntry;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> genreSumMap = new HashMap<>();
        HashMap<String, PriorityQueue<Entry<Integer, Integer>>> genrePlays 
            = new HashMap<>();
        PriorityQueue<Entry<String, Integer>> genreRankQueue 
            = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        
        for (int i = 0; i < genres.length; i++) {
            PriorityQueue<Entry<Integer, Integer>> temp;
            
            if (genrePlays.containsKey(genres[i])) {
                temp = genrePlays.get(genres[i]);
                temp.add(new SimpleEntry(i, plays[i]));
            } else {
                temp = new PriorityQueue<>(
                    Comparator.comparing(Entry<Integer, Integer>::getValue, Comparator.reverseOrder())
                    .thenComparing(Entry<Integer, Integer>::getKey)
                );
                temp.add(new SimpleEntry(i, plays[i]));
                genrePlays.put(genres[i], temp);
            }
            
            genreSumMap.put(genres[i], genreSumMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        genreRankQueue.addAll(genreSumMap.entrySet());
        
        while (genreRankQueue.size() > 0) {
            String genre = genreRankQueue.poll().getKey();
            PriorityQueue<Entry<Integer, Integer>> genreQueue = genrePlays.get(genre);
            
            answer.add(genreQueue.poll().getKey());
            if (genreQueue.size() > 0)
                answer.add(genreQueue.poll().getKey());
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}