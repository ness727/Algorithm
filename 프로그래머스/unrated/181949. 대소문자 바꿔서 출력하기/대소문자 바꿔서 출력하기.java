import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        StringBuilder st = new StringBuilder();
        
        for (char c : a.toCharArray()) {
            if (c < 91) st.append(String.valueOf(c).toLowerCase());
            else st.append(String.valueOf(c).toUpperCase());
        }
        System.out.println(st.toString());
    }
}