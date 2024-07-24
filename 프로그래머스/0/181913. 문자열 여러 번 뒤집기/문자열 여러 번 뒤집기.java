class Solution {
    public String solution(String my_string, int[][] queries) {
        StringBuilder result = new StringBuilder(my_string);
        StringBuilder temp = new StringBuilder();
        
        for (int[] q : queries) {
            temp.setLength(0);
            temp.append(result.substring(q[0], q[1] + 1));
            result.replace(q[0], q[1] + 1, temp.reverse().toString());
        }
        return result.toString();
    }
}