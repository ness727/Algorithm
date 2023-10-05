import java.util.Comparator;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] numlist, int n) {
        return IntStream.range(0, numlist.length).boxed()
            .sorted(Comparator.comparing((Integer i) -> Math.abs(n - numlist[i]))
                    .thenComparing((Integer i, Integer j) -> numlist[j] - numlist[i]))
            .mapToInt(i -> numlist[i]).toArray();
    }
}