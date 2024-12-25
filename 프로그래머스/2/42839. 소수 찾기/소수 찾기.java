import java.util.HashSet;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        HashSet<Integer> numSet = new HashSet<>();
        
        // 초기 숫자 추가
        for (String num : numbers.split("")) numSet.add(Integer.parseInt(num));
        
        // 모든 가능한 숫자 조합 구하기
        findAll("", numbers, numSet);
        
        // 소수 확인하기
        for (Integer num : numSet) answer += isPrime(num);
        
        return answer;
    }
    
    private void findAll(String pre, String numStr, HashSet<Integer> numSet) {
        if (numStr.length() != 0) {
            for (int i = 0; i < numStr.length(); i++) {
                String newNum = pre + numStr.charAt(i);
                numSet.add(Integer.parseInt(newNum));
                findAll(newNum, new StringBuilder(numStr).delete(i, i + 1).toString(), numSet);
            }
        }
    }
    
    private int isPrime(int num) {
        if (num == 0 || num == 1) return 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return 0;
        }
        return 1;
    }
}