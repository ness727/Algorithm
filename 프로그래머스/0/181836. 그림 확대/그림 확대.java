import java.util.Arrays;

class Solution {
    public String[] solution(String[] picture, int k) {
        return Arrays.stream(picture)
            .map(p -> {
                String[] result = new String[k];
                p = p.replaceAll("\\.", ".".repeat(k))
                        .replaceAll("x", "x".repeat(k));
                for (int i = 0; i < k; i++) result[i] = p;
                return result;
            })
            .flatMap(Arrays::stream)
            .toArray(String[]::new);
    }
}