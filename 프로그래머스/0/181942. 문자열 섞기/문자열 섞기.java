import java.util.stream.IntStream;

class Solution {
    public String solution(String str1, String str2) {
        return IntStream.range(0, str1.length())
            .mapToObj(i -> str1.substring(i, i + 1) + str2.substring(i, i + 1))
            .reduce((s1, s2) -> s1 + s2)
            .get();
    }
}