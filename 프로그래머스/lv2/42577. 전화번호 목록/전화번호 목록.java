import java.util.HashMap;
import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> result = new HashMap<>();
        HashSet<Integer> numLenSet = new HashSet<>();
        
        Arrays.sort(phone_book, (num1, num2) -> num1.length() - num2.length());
        
        for (int i = 0; i < phone_book.length; i++) {
            result.put(phone_book[i], 1);
            for (Integer num : numLenSet)
                if (num != phone_book[i].length())
                    if (result.containsKey(phone_book[i].substring(0, num))) return false;
            numLenSet.add(phone_book[i].length());
        }
        return true;
    }
}