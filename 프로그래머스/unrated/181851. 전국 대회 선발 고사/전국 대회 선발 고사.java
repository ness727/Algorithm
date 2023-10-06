import java.util.stream.IntStream;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int[] answer = IntStream.range(0, rank.length)
            .filter(i -> attendance[i])
            .boxed()
            .sorted((i, j) -> rank[i] - rank[j])
            .limit(3)
            .mapToInt(i -> i)
            .toArray();
        return 10000 * answer[0] + 100 * answer[1] + answer[2];
    }
}