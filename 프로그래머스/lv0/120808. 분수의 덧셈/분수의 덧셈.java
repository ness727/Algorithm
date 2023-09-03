import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        ArrayList<HashSet<Integer>> numSetList = new ArrayList<>();
        int[] num = new int[] { denom1, denom2 };
        int max, min, numer3;
        
        for (int i = 0; i < 2; i++) numSetList.add(getDivisor(num[i]));
        
        numSetList.get(0).retainAll(numSetList.get(1));
        max = Collections.max(numSetList.get(0));
        min = num[0] * num[1] / max;
        
        numer1 *= min / num[0];
        numer2 *= min / num[1];
        
        numer3 = numer1 + numer2;
        
        numSetList.add(getDivisor(numer3));
        numSetList.add(getDivisor(min));
        
        numSetList.get(2).retainAll(numSetList.get(3));
        
        max = Collections.max(numSetList.get(2));
        
        return new int[] { numer3 / max, min / max };
    }
    
    public static HashSet<Integer> getDivisor(int num) {
        HashSet<Integer> result = new HashSet<>();
        
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                result.add(i);
                result.add(num / i);
            }
        }
        return result;
    }
}