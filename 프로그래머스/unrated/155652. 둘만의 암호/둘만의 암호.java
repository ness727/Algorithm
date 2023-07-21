class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        char[] c =  s.toCharArray();
        int[] skipArr = new int[26];
        
        for (int i = 97; i < 123; i++) {
            for (int j = 0; j < skip.length(); j++) {
                if (skip.charAt(j) == i) {
                    skipArr[i - 97] = 0;
                    break;
                }
                else {
                    skipArr[i - 97] = 1;
                }
            }
        }
        
        for (int i = 0; i < c.length; i++) {
            int charValue = c[i];
            int sum = 0;
            
            while (sum < index) {
                charValue++;
                if (charValue == 123) charValue = 97;
                sum += skipArr[charValue - 97];
            }
            c[i] = (char)charValue;
        }
        answer = String.valueOf(c);
        
        return answer;
    }
}