import java.util.HashSet;
import java.util.ArrayList;

class Solution {
    public int solution(int[] cards) {
        ArrayList<HashSet<Integer>> indexGroupList = new ArrayList<>();
        HashSet<Integer> checkSet = new HashSet<>();
        
        for (int i = 0; i < cards.length; i++) {
            if (checkSet.contains(i)) continue;
            HashSet<Integer> indexGroupSet = new HashSet<>();
            
            int index = i;
            while (!indexGroupSet.contains(index)) {
                indexGroupSet.add(index);
                checkSet.add(index);
                index = cards[index] - 1;
            }
            indexGroupList.add(indexGroupSet);
        }
        if (indexGroupList.size() == 1) return 0;
        else return indexGroupList.stream()
            .map(s -> s.size())
            .filter(i -> i != 1)
            .sorted((i, j) -> j - i)
            .limit(2)
            .reduce(1, (i, j) -> i * j);
    }
}