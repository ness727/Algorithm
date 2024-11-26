import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[] cards = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int result = 0;
        
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int tempSum = cards[i] + cards[j] + cards[k];
                    if (tempSum <= m) result = Math.max(tempSum, result);
                }
            }
        }
        
        writer.append(String.valueOf(result)).flush();
    }
}