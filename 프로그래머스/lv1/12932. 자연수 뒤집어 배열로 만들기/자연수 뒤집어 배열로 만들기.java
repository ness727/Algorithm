class Solution {
    public int[] solution(long n) {
        return new StringBuilder(Long.toString(n)).reverse().toString().chars()
            .map(Character::getNumericValue)
            .toArray();
    }
}