import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

class Solution {
    int answer = 0;
    public int solution(int[] picks, String[] minerals) {
        final int picksLen = (picks[0] + picks[1] + picks[2]) * 5;
        int minLen = (minerals.length > picksLen) ? picksLen : minerals.length;
        ArrayList<ArrayList<String>> mineralLists = new ArrayList<>();
        HashMap<ArrayList<String>, Integer> stonePickMap = new HashMap<>();
        HashMap<String, int[]> mineralMap = new HashMap<>() {{
                                                put("diamond", new int[] { 1, 5, 25 });
                                                put("iron", new int[] { 1, 1, 5 });
                                                put("stone", new int[] { 1, 1, 1 }); 
                                            }};
        
        for (int i = 0; i < minLen; i += 5) {  // minerals를 광석 리스트로 변환
            mineralLists.add(new ArrayList<>());
            for (int j = i; j < ((i + 4 < minLen) ? i + 5 : minLen); j++) 
                mineralLists.get(mineralLists.size() - 1).add(minerals[j]);
        }
        
        for (ArrayList<String> mineralList : mineralLists) {  // 돌 곡괭이 기준 피로도 합 계산 후 값 넣어줌
            int sum = 0;
            for (String mineral : mineralList) sum += mineralMap.get(mineral)[2];
            stonePickMap.put(mineralList, sum);
        }
        
        // 돌 곡괭이 기준 피로도 높은 순으로 정렬
        ArrayList<ArrayList<String>> sortedMineralLists = new ArrayList(mineralLists.stream() 
                                                   .sorted((l1, l2) -> stonePickMap.get(l2) - stonePickMap.get(l1)).collect(Collectors.toList()));
        
        for (int i = 0; i < mineralLists.size(); i++) {
            if (picks[0] > 0) {  // 다이아몬드 곡괭이 사용 시
                sortedMineralLists.get(i).forEach(m -> answer += mineralMap.get(m)[0]);
                picks[0]--;
            }
            else if (picks[1] > 0) {  // 철 곡괭이 사용 시
                sortedMineralLists.get(i).forEach(m -> answer += mineralMap.get(m)[1]);
                picks[1]--;
            }
            else {  // 돌 곡괭이 사용 시
                sortedMineralLists.get(i).forEach(m -> answer += mineralMap.get(m)[2]);
                picks[2]--;
            }
        }
        
        return answer;
    }
}