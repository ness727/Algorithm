class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder st = new StringBuilder();
        
        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) st.append(i);
        }
        answer = st.toString();
        return answer + st.append(0).reverse();
    }
}