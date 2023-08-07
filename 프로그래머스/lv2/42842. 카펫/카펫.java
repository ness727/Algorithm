class Solution {
    public int[] solution(int brown, int yellow) {
        final int total = brown + yellow;
        
        for (int i = 3; i <= Math.sqrt(total); i++)
            if (total % i == 0)
                if (total - (total / i * 2 + (i - 2) * 2) == yellow) 
                    return new int[] { total / i, i };
        return null;
    }
}