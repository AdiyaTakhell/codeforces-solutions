import java.io.*;
import java.util.*;

public class ANumbersOnTheBoard {

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
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

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    static InputReader r = new InputReader(System.in);
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = r.nextInt();

        while (t-- > 0) {
            long l = r.nextLong();
            long rr = r.nextLong();

            long n = rr - l + 1;
            long total = (l + rr) * n / 2;

            long answer = 0;

            for (long k = 1; k <= n; k++) {
                long mn = k * l + k * (k - 1) / 2;
                long mx = k * rr - k * (k - 1) / 2;

                if (mn <= total && total <= mx) {
                    answer = k - 1;
                    break;
                }
            }

            pw.println(answer);
        }

        pw.close();
    }
}