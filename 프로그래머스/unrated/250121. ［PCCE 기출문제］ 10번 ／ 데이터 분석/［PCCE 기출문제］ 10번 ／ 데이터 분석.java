import java.util.Arrays;
import java.util.Map;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> extMap = Map.of("code", 0, 
                                             "date", 1, 
                                             "maximum", 2, 
                                             "remain", 3);
        
        return Arrays.stream(data)
            .filter(arr -> arr[extMap.get(ext)] < val_ext)
            .sorted((int[] arr1, int[] arr2) -> arr1[extMap.get(sort_by)] - arr2[extMap.get(sort_by)])
            .toArray(int[][]::new);
    }
}