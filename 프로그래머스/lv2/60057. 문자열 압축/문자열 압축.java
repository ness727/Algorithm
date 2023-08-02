import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public int solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int i = 1; i <= (int)Math.floor(s.length() / 2); i++) {
            ArrayList<String> result = new ArrayList<>();
            ArrayList<Integer> countList = new ArrayList<>();
            Stack<String> count = new Stack<>();
            StringBuilder stb = new StringBuilder();
            
            for (int j = 0; j < s.length() - s.length() % i; j += i)
                result.add(s.substring(j, j + i));
            
            for (int j = 0; j < result.size(); j++) {
                if (count.empty()) count.push(result.get(j));
                else if (count.peek().equals(result.get(j))) count.push(result.get(j));
                else {
                    if (count.size() != 1) countList.add(count.size());
                    count.clear();
                    count.push(result.get(j));
                }
                if (j == result.size() - 1 && count.size() != 1) countList.add(count.size());
            }
            
            if (countList.size() > 0) {
                for (int j = 0; j < countList.size(); j++) stb.append("*".repeat(i));
                for (Integer j : countList) stb.append(j);
                answer.add(stb.toString().length() + s.length() - i * countList.stream().mapToInt(j -> j).sum());
            }
        }
        
        return (answer.size() == 0) ? s.length() : answer.stream().filter(i -> i > 0).mapToInt(i -> i).min().getAsInt();
    }
}