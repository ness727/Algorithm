class Solution {
    public String solution(String code) {
        boolean mode = false;
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < code.length(); i++) {
            String subStr = code.substring(i, i + 1);
            
            if (mode) {
                if (subStr.equals("1")) mode = false;
                else { if (i % 2 != 0) answer.append(subStr); }
            }
            else {
                if (subStr.equals("1")) mode = true;
                else { if (i % 2 == 0) answer.append(subStr); }
            }
        }
        return answer.length() == 0 ? "EMPTY" : answer.toString();
    }
}