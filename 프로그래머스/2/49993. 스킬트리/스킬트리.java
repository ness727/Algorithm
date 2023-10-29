class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        final String check = new StringBuilder()
            .append("[^").append(skill).append("]*").toString();
        
        for (String sk : skill_trees) {
            if (sk.matches(check)) answer++;
            else {
                sk = sk.replaceAll(check, "");
                for (int i = 0; i < sk.length(); i++) {
                    if (skill.charAt(i) != sk.charAt(i)) break;
                    else if (i == sk.length() - 1) answer++;
                }
            }
        }
        return answer;
    }
}