import java.util.Comparator;

class Solution {
    public long solution(long n) {
        return Long.parseLong(String.valueOf(n).chars()
            .map(Character::getNumericValue)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .map(String::valueOf)
            .reduce((i, j) -> i + j).orElse(""));
    }
}