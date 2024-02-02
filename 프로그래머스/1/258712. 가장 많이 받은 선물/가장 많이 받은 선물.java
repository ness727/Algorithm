import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int[] answer = new int[friends.length];
        HashMap<String, Gift> giftMap = new HashMap<>();
        
        // 주어진 대로 세팅
        for (String name : friends) giftMap.put(name, new Gift());
        for (String gift : gifts) {
            String[] names = gift.split(" ");
            giftMap.get(names[0]).addGivenList(names[1]);
            giftMap.get(names[1]).addReceivedList(names[0]);
        }
        
        for (int i = 0; i < friends.length - 1; i++) {
            Gift a = giftMap.get(friends[i]);
            
            for (int j = i + 1; j < friends.length; j++) {
                Gift b = giftMap.get(friends[j]);
                
                // 주고 받은 기록이 있을 때
                if (a.getGivenList().contains(friends[j]) 
                    || a.getReceivedList().contains(friends[j])) {
                    int aGivenCount = Collections.frequency(a.getGivenList(), friends[j]);
                    int bGivenCount = Collections.frequency(b.getGivenList(), friends[i]);
                    
                    if (aGivenCount < bGivenCount) {
                        answer[j]++;
                    } else if (aGivenCount > bGivenCount) {
                        answer[i]++;
                    } else {
                        if (a.getScore() < b.getScore()) {
                            answer[j]++;
                        } else if (a.getScore() > b.getScore()) {
                            answer[i]++;
                        }
                    }
                } else {  // 주고 받은 기록이 없을 때
                    if (a.getScore() < b.getScore()) {
                        answer[j]++;
                    } else if (a.getScore() > b.getScore()) {
                        answer[i]++;
                    }
                }
            }
        }
        return Arrays.stream(answer).max().getAsInt();
    }
    
    static class Gift {
        private ArrayList<String> givenList = new ArrayList<>();
        private ArrayList<String> receivedList = new ArrayList<>();
        private int score;
        
        public ArrayList<String> getGivenList() { return givenList; }
        public ArrayList<String> getReceivedList() { return receivedList; }
        public int getScore() { return givenList.size() - receivedList.size(); }
        
        public void addGivenList(String name) { givenList.add(name); }
        public void addReceivedList(String name) { receivedList.add(name); }
    }
}