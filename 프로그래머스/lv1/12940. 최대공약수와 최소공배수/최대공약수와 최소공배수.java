import java.util.Collections;
import java.util.HashSet;

class Solution {
    public int[] solution(int n, int m) {
        HashSet<Integer> nSet = new HashSet<>();
        HashSet<Integer> mSet = new HashSet<>();
        
        for (int i = 1; i <= (int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                nSet.add(i);
                nSet.add(n / i);
            }
        }
        
        for (int i = 1; i <= (int)Math.sqrt(m); i++) {
            if (m % i == 0) {
                mSet.add(i);
                mSet.add(m / i);
            }
        }
        nSet.retainAll(mSet);
        
        return new int[] { Collections.max(nSet), n * m / Collections.max(nSet)};
    }
}