import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<HashSet<Integer>> result = new ArrayList<>();
        Pattern pattern = Pattern.compile("(\\d,*)+");
        Matcher matcher = pattern.matcher(s);
        
        while(matcher.find()) {
            String[] strNum = matcher.group().split("\\,");
            HashSet<Integer> currentSet = new HashSet<>();
            
            result.add(currentSet);
            for (int i = 0; i < strNum.length; i++)
                currentSet.add(Integer.parseInt(strNum[i]));
        }
        
        result = result.stream()
            .sorted((l1, l2) -> l1.size() - l2.size())
            .collect(Collectors.toCollection(ArrayList::new));
        
        for (int i = 0; i < result.size(); i++)
            for (int j : result.get(i))
                if (!answer.contains(j)) answer.add(j);
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}