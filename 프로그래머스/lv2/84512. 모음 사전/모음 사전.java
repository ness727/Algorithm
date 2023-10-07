class Solution {
    String[] strArr = new String[] { "A", "E", "I", "O", "U" };
    String answer;
    int count = 0;
    
    public int solution(String word) {
        answer = word;
        for (int i = 0; i < 5; i++) if(doDfs("", strArr[i])) return count;
        
        return -1;
    }
    
    private boolean doDfs(String result, String addStr) {
        StringBuilder tempWord = new StringBuilder().append(result).append(addStr);
        String tempToStr = tempWord.toString();
        
        count++;
        if (tempToStr.equals(answer)) return true;
        
        for (int i = 0; i < 5; i++) {
            if (tempToStr.length() < 5)
                if (doDfs(tempToStr, strArr[i])) return true;
        }
        
        return false;
    }
}