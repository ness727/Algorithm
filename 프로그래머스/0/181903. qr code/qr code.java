import java.util.stream.IntStream;

class Solution {
    public String solution(int q, int r, String code) {
        return IntStream.range(0, code.length())
            .filter(i -> i % q == r)
            .mapToObj(i -> code.substring(i, i+1))
            .reduce((s1, s2) -> s1 + s2)
            .get();
    }
}