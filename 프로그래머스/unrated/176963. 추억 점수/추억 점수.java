class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        int count = 0;
        
        for (String[] p : photo) {
            answer[count] = 0;
            for (String s : p) {
                for (int i = 0; i < name.length; i++) {
                    if (s.equals(name[i])) {
                        answer[count] += yearning[i];
                        break;
                    }
                }
            }
            count++;
        }
        
        return answer;
    }
}