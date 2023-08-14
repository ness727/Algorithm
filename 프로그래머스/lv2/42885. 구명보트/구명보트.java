import java.util.Arrays;

class Solution {    
    public int solution(int[] people, int limit) {
        int answer = 0;
        int pre = 0;
        int post = people.length - 1;
        
        Arrays.sort(people);
        while(post >= pre) {
            if (people[pre] + people[post] <= limit) {
                pre++;
                post--;
            }
            else post--;
            answer++;
        }
        
        return answer;
    }
}