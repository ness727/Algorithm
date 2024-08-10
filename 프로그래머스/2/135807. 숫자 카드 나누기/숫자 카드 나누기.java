class Solution {
    public int solution(int[] arrayA, int[] arrayB) {       
        int aMax = arrayA[0], bMax = arrayB[0];
        for (int i = 1; i < arrayA.length; i++) {
            aMax = gcd(aMax, arrayA[i]);
        }
        for (int i = 1; i < arrayB.length; i++) {
            bMax = gcd(bMax, arrayB[i]);
        }
        
        boolean aCheck = true, bCheck = true;
        for (int a : arrayA) {
            if (a % bMax == 0) {
                bCheck = false;
                break;
            }
        }
        for (int b : arrayB) {
            if (b % aMax == 0) {
                aCheck = false;
                break;
            }
        }
        
        if (aCheck && bCheck) return Math.max(aMax, bMax);
        else if (aCheck) return aMax;
        else if (bCheck) return bMax;
        else return 0;
    }
    
    private int gcd(int i, int j) {
        if (j == 0) return i;
        else return gcd(j, i % j);
    }
}