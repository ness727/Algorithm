class Solution {
    public String solution(String s) {
        StringBuilder result = new StringBuilder();
        String[] str = s.trim().split(" +");
        String[] space = s.split("[^ ]+");
        
        for(int i = 0; i < str.length; i++) {
            if(!str[i].matches("^\\d")) {
                result.append(str[i].substring(0, 1).toUpperCase());
                result.append(str[i].substring(1).toLowerCase());
            }
            str[i] = result.toString();
            result.setLength(0);
        }
            
        for (int i = 0; i < str.length; i++) {
            if (space.length > 0) result.append(space[i]);
            result.append(str[i]);
        }
        if (space.length > str.length) result.append(space[space.length - 1]);
        
        return result.toString();
    }
}