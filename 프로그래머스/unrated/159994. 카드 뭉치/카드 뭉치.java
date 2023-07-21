import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> cards1Queue = new LinkedList<>();
        Queue<String> cards2Queue = new LinkedList<>();
        
        for (String card : cards1) cards1Queue.add(card);
        for (String card : cards2) cards2Queue.add(card);
        for (String goalStr : goal) {
            if (goalStr.equals(cards1Queue.peek())) cards1Queue.remove();
            else if (goalStr.equals(cards2Queue.peek())) cards2Queue.remove();
            else return "No";
        }
        return "Yes";
    }
}