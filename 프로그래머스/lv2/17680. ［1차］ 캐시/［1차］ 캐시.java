import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> cache = new LinkedList<>();
        int answer = 0;
        
        for (int i = 0; i < cities.length; i++) {
            String lowerCity = cities[i].toLowerCase();
            
            if (cacheSize == 0) answer += 5; // 캐시 사이즈가 0일 때
            else {
                if(!cache.contains(lowerCity)) {  // cache miss
                    if (cache.size() == cacheSize) cache.poll();
                    cache.add(lowerCity);
                    answer += 5;
                }
                else {  // cache hit
                    Queue<String> newCache = new LinkedList<>();
                    
                    int count = (cache.size() == cacheSize ? cacheSize : cache.size());
                    for (int j = 0; j < count; j++) {
                        String city = cache.poll();
                        if (!city.equals(lowerCity)) newCache.add(city);
                    }
                    newCache.add(lowerCity);
                    cache = newCache;
                    answer++;
                }
            }
        }
        return answer;
    }
}