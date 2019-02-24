import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.function.Predicate;

public class LeftArrayRotation {

       // Complete the rotLeft function below.
    static int[] rotLeft(int[] input, int depth) {
    	if(depth==0) {
            return input;
        }
        else {
        int first=input[0];
         IntStream.rangeClosed(1, input.length-1).forEach(a1->input[a1-1] = input[a1]);
         input[input.length-1]=first;
         return rotLeft(input, depth-1);
        }
    }
    
    
   

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);
Predicate<Integer> numberCheck = i -> (i>=n &&  i<=Math.pow(10, 5));
        Predicate<Integer> depthCheck= i->(i>=1 && i<=n);
          
        Predicate<Integer> individualCheck= i->(i>=1 && i<=Math.pow(10, 6));
        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
boolean ok = false;
        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
           ok=individualCheck.test(a[i]);
        }
if(numberCheck.test(n) && depthCheck.test(d) && ok){
        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }
    }
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
