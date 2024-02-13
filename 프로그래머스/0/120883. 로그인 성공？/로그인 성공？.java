import java.util.Arrays;

class Solution {
    public String solution(String[] id_pw, String[][] db) {
        return Arrays.stream(db)
            .filter(arr -> id_pw[0].equals(arr[0]))
            .map(arr -> id_pw[1].equals(arr[1]) ? "login" : "wrong pw")
            .findAny().orElse("fail");
    }
}