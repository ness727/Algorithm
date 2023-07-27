import java.util.Scanner;
import java.math.BigDecimal;
import java.math.MathContext;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int caseNum = s.nextInt();
        int[] xyr = new int[6];
        
        for (int i = 0; i < caseNum; i++) {
            for (int j = 0; j < 6; j++) xyr[j] = s.nextInt();

            BigDecimal distance = BigDecimal.valueOf((int)Math.pow(xyr[0] - xyr[3], 2) + (int)Math.pow(xyr[1] - xyr[4], 2));
            int compareDis = distance.compareTo(BigDecimal.valueOf((int)Math.pow(xyr[2] + xyr[5], 2)));

            if (xyr[0] == xyr[3] && xyr[1] == xyr[4] && xyr[2] == xyr[5]) System.out.println("-1");
            else if (compareDis == 1) System.out.println("0");
            else if (compareDis == -1) {
                BigDecimal temp = distance.sqrt(new MathContext(30)).add(BigDecimal.valueOf(Math.min(xyr[2], xyr[5])));
                int compareTemp = temp.compareTo(BigDecimal.valueOf(Math.max(xyr[2], xyr[5])));

                if (compareTemp == -1) System.out.println("0");
                else if (compareTemp == 1) System.out.println("2");
                else System.out.println("1");
            }
            else System.out.println("1");
        }
    }
}