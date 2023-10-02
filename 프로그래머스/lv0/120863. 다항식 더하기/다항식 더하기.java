class Solution {
    public String solution(String polynomial) {
        StringBuilder answer = new StringBuilder();
        String[] result = polynomial.split(" \\+ ");
        int[] sum = new int[2];
        
        for (String s : result) {
            if (s.contains("x")) {
                if (s.equals("x")) sum[0]++;
                else sum[0] += Integer.parseInt(s.replace("x", ""));
            }
            else sum[1] += Integer.parseInt(s);
        }
        return answer.append(sum[0] != 0 ? (sum[0] == 1 ? "x" : sum[0] + "x") : "")
            .append(sum[0] != 0 && sum[1] != 0 ? " + " : "") 
            .append(sum[1] != 0 ? sum[1] : "").toString();
    }
}