import java.util.Arrays;

class Solution
{
    public int solution(int[] A, int[] B)
    {
        int answer = 0;
        
        Arrays.sort(A);
        for (int i = 0; i < B.length; i++) B[i] *= -1;
        Arrays.sort(B);
        for (int i = 0; i < A.length; i++) answer += A[i] * -B[i];
        return answer;
    }
}