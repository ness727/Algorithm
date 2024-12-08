import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        return Arrays.stream(numbers)
            .boxed()
            .sorted((a, b) -> {
                String strA = String.valueOf(a) + String.valueOf(b);
                String strB = String.valueOf(b) + String.valueOf(a);
                return strB.compareTo(strA);
            })
            .map(String::valueOf)
            .collect(Collectors.joining())
            .replaceFirst("^00*0$", "0");
    }
}