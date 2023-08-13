class Solution {
    public String solution(String s) {
        StringBuilder strBuilder = new StringBuilder();
        String[] sArr = s.split("\\b +\\b");
        String spaceStr = s.replaceAll("\\w+", "!");
        
        for (String str : sArr) {
            strBuilder.setLength(0);
            str = str.trim();
            for (int i = 0; i < str.length(); i++) {
                if (i % 2 == 0) strBuilder.append(str.substring(i, i + 1).toUpperCase());
                else strBuilder.append(str.substring(i, i + 1).toLowerCase());
            }
            spaceStr = spaceStr.replaceFirst("\\!", strBuilder.toString());
        }
        return spaceStr;
    }
}