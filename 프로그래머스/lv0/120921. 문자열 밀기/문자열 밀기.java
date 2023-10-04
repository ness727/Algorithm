class Solution {
    public int solution(String A, String B) {
        StringBuilder result = new StringBuilder();
        
        result.append(A.toCharArray()).append(A.toCharArray());
        for (int answer = 0, i = result.length() - 1; i >= A.length(); answer++, i--) {
            if (result.substring(i - (A.length() - 1), i + 1).toString().equals(B))
                return answer;
        }
        return -1;
    }
}