class Solution {
    public long solution(String numbers) {
        String[] numArr = new String[] { "zero", "one", "two", "three", "four", "five",
                                        "six", "seven", "eight", "nine" };
        for (int i = 0; i < 10; i++) numbers = numbers.replaceAll(numArr[i], String.valueOf(i));
        return Long.valueOf(numbers);
    }
}