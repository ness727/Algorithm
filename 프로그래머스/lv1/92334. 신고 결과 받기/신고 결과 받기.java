import java.util.ArrayList;
import java.util.stream.*;
import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, ArrayList<String>> reportMap = new HashMap<>();
        HashMap<String, Integer> resultMap = new HashMap<>();
        
        Arrays.stream(report).distinct().forEach((str) -> {
            String[] reportArr = str.split(" ");
            if (!reportMap.containsKey(reportArr[1]))
                reportMap.put(reportArr[1], new ArrayList<String>());
            reportMap.get(reportArr[1]).add(reportArr[0]);
        });

        reportMap.values().stream()
            .filter(list -> list.stream().distinct().collect(Collectors.toList()).size() >= k)
            .forEach((list) -> { list.forEach(str -> resultMap.put(str, resultMap.getOrDefault(str, 0) + 1)); });
        return Arrays.stream(id_list).mapToInt(str -> resultMap.getOrDefault(str, 0)).toArray();
    }
}