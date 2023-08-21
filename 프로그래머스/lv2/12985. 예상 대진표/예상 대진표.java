class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        boolean isFlip = false;
        
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        
        for (int i = 1; i <= n;) {
            answer = (isFlip) ? answer - 1 : answer + 1;
            if (a <= i && (i < b && b <= i * 2)) return answer;
            else {
                if ((i < a && a <= i * 2) && (i < b && b <= i * 2)) {
                    int tempB = b;
                    b = i * 2 - a + 1;
                    a = i * 2 - tempB + 1;
                    isFlip = true;
                }
                i = (isFlip) ? i / 2 : i * 2;
            }
        }

        return answer;
    }
}