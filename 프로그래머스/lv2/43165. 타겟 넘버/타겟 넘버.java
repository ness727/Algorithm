class Solution {
    int answer = 0;
    int[] numbers;
    int target;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        doDfs(0, 0);
        return answer;
    }
    
    public void doDfs(int index ,int result) {        
        int result1 = result + numbers[index];
        int result2 = result - numbers[index];
        
        if (index == numbers.length - 1) {
            if (result1 == target) ++answer;
            if (result2 == target) ++answer;
        }
        
        if (index < numbers.length - 1) {
            doDfs(index + 1, result1);
            doDfs(index + 1, result2);
        }
    }
}