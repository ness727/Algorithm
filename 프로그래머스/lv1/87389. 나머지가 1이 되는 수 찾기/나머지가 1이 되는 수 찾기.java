import java.util.stream.*;

class Solution {
    public int solution(int n) {
        return IntStream.rangeClosed(2, n).filter(i -> n % i == 1).min().getAsInt();
    }
}