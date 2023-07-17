class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        int minLength = Integer.MAX_VALUE;
        int count = 0;
        int first = 0;
        int sum = 0;
        
        while(count != sequence.length) {
            sum += sequence[count];
            if (sum < k) count++;
            else if (sum == k) {
                if (count - first + 1 < minLength) {
                    minLength = count - first + 1;
                    answer = new int[] { first, count };
                }
                sum -= sequence[first];
                first++;
                count++;
            }
            else {
                sum -= sequence[count];
                sum -= sequence[first];
                first++;
            }
        }
        return answer;
    }
}