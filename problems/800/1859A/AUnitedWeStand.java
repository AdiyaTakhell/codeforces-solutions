
import java.io.*;
import java.util.*;

public class AUnitedWeStand {

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(
                new InputStreamReader(stream), 32768
            );
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }

    static InputReader r = new InputReader(System.in);
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {

        int t = r.nextInt();

        while (t-- > 0) {

            int n = r.nextInt();
            int[] a = new int[n];

            int min = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                a[i] = r.nextInt();
                min = Math.min(min, a[i]);
            }

            int count = 0;

            for (int num : a) {
                if (num == min) {
                    count++;
                }
            }

            if (count == n) {
                pw.println(-1);
                continue;
            }

            pw.println(count + " " + (n - count));

            for (int i = 0; i < n; i++) {
                if (a[i] == min) {
                    pw.print(a[i] + " ");
                }
            }
            pw.println();

            for (int i = 0; i < n; i++) {
                if (a[i] != min) {
                    pw.print(a[i] + " ");
                }
            }
            pw.println();
        }

        pw.flush();
    }
}
