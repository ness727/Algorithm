import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

import static java.util.Map.Entry;

class Solution {
    int[] answer = {};
    int max = 0;
    
    public int[] solution(int[][] dice) {
        selectDices(new ArrayList<>(), dice, -1, dice.length / 2);
        return answer;
    }
    
    private void selectDices(List<Integer> diceIndexList, int[][] dice, int minNum, int count) {
        if (count == 0) {  // 주사위가 다 나뉘었을 때
            // 내 주사위 굴리기 시작
            PriorityQueue<Entry<Integer, Integer>> myResult = startGame(diceIndexList, 0, null, dice, true);
            
            // 상대방 주사위 굴리기 시작
            ArrayList<Integer> enemyDiceIndexList = new ArrayList<>();
            for (int i = 0; i < dice.length; i++) {
                if (!diceIndexList.contains(i)) enemyDiceIndexList.add(i);
            }
            PriorityQueue<Entry<Integer, Integer>> enemyResult = startGame(enemyDiceIndexList, 0, null, dice, false);
            
            // 나의 승리 수 구하기
            int mySum = 0, enemySum = 0;
            while (!myResult.isEmpty()) {
                Entry<Integer, Integer> myEntry = myResult.poll();
                
                while (!enemyResult.isEmpty() && enemyResult.peek().getKey() < myEntry.getKey()) {
                    enemySum += enemyResult.poll().getValue();
                }
                mySum += myEntry.getValue() * enemySum;
            }
            
            // 승리 수 높은 주사위로 갱신
            if (max < mySum) {
                max = mySum;
                answer = new int[diceIndexList.size()];
                for (int i = 0; i < diceIndexList.size(); i++) answer[i] = diceIndexList.get(i) + 1;
            }
        }
        
        // 내 주사위 선택하는 과정
        for (int i = 0; i < dice.length; i++) {
            if (minNum < i) {
                List<Integer> nextDiceIndexList = new ArrayList<>();
                nextDiceIndexList.addAll(diceIndexList);
                nextDiceIndexList.add(i);
                selectDices(nextDiceIndexList, dice, i, count - 1);
            }
        }
    }
    
    private PriorityQueue<Entry<Integer, Integer>> startGame(List<Integer> diceIndexList, int index, 
                                             Map<Integer, Integer> prevMap, int[][] dice, boolean mine) {
        // 첫 주사위일 때
        if (index == 0) {
            HashMap<Integer, Integer> nextNumCountMap = new HashMap<>();

            for (int i = 0; i < 6; i++) {
                int diceIndex = diceIndexList.get(index);
                nextNumCountMap.put(dice[diceIndex][i], nextNumCountMap.getOrDefault(dice[diceIndex][i], 0) + 1);
            }
            return startGame(diceIndexList, index + 1, nextNumCountMap, dice, mine);
        } 
        // 나머지 주사위 굴리기
        else if (index < diceIndexList.size()) {
            HashMap<Integer, Integer> numCountMap = new HashMap<>();
            HashMap<Integer, Integer> nextNumCountMap = new HashMap<>();
            
            for (int i = 0; i < 6; i++) {
                int diceIndex = diceIndexList.get(index);
                numCountMap.put(dice[diceIndex][i], numCountMap.getOrDefault(dice[diceIndex][i], 0) + 1);
            }
            for (Entry<Integer, Integer> numCountEntry : numCountMap.entrySet()) {
                for (Entry<Integer, Integer> prevEntry : prevMap.entrySet()) {
                    Integer key = numCountEntry.getKey() + prevEntry.getKey();
                    Integer value = numCountEntry.getValue() * prevEntry.getValue();
                    nextNumCountMap.put(key, nextNumCountMap.getOrDefault(key, 0) + value);
                }
            }
            return startGame(diceIndexList, index + 1, nextNumCountMap, dice, mine);
        }
        // 주사위를 전부 굴렸을 때
        else {
            PriorityQueue<Entry<Integer, Integer>> result;
            
            if (mine) result = new PriorityQueue<>((entry1, entry2) -> entry1.getKey() - entry2.getKey());
            else result = new PriorityQueue<>((entry1, entry2) -> entry1.getKey() - entry2.getKey());
            
            result.addAll(prevMap.entrySet());
            return result;
        }
    }
}