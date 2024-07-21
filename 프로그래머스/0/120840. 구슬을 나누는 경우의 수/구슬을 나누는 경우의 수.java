import java.util.stream.Stream;
import java.math.BigInteger;

class Solution {
    public int solution(int balls, int share) {
        return (getFactorial(balls).divide(
            getFactorial(balls - share).multiply(
                getFactorial(share))
            )
        ).intValue();
    }
    
    private BigInteger getFactorial(int num) {
        return Stream.iterate(BigInteger.ONE, i -> i.add(BigInteger.ONE))
            .limit(num)
            .reduce(BigInteger.ONE, BigInteger::multiply);
    }
}