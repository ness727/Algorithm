import java.util.stream.IntStream;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        return IntStream.range(0, n)
            .mapToObj(i -> String.format("%" + n + "s", Integer.toBinaryString(arr1[i] | arr2[i])).replace(" ", "0"))
            .map(b -> b.replaceAll("1", "#").replaceAll("0", " "))
            .toArray(String[]::new);
    }
}