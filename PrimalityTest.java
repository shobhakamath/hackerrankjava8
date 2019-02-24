
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PrimalityTest {

    // Complete the primality function below.
	 static String primality(int number) {
         return (number >= 2
           && IntStream.rangeClosed(2, (int) Math.sqrt(number))
           .noneMatch(n -> (number % n == 0)))?"Prime":"Not prime";
 }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int pItr = 0; pItr < p; pItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = primality(n);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
