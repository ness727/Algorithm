public class Solution {
    public int solution(int n) {
        return Integer.toString(n).chars().map(Character::getNumericValue).sum();
    }
}