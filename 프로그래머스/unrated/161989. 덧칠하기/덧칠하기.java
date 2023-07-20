import java.util.ArrayList;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        ArrayList<Integer> sectionList = new ArrayList<Integer>();
        
        sectionList.add(0);
        
        for (int i = 0; i < section.length; i++) {
            sectionList.add(section[i]);
        }
        
        for (int i = 1; i <= n; i++) {
            if (sectionList.contains(i)) {
                    answer++;

                    if (i + m > n) break;

                    for (int j = 0; j < m; j++) {
                        if(sectionList.contains(i + j)) {
                            sectionList.set(sectionList.indexOf(i + j), 0);
                        }
                    }
                
            }
        }
        return answer;
    }
}