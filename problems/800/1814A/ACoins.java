import java.io.*;
import java.util.*;

public class ACoins {

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
            long n = r.nextLong();
            long k = r.nextLong();
            if (n % 2 == 0 || k == 1 || n == k) {
                pw.println("Yes");
            } else {
                if ((n - k) % 2 == 0) {
                    pw.println("yes");
                } else {
                    pw.println("No");
                }
            }

        }

        pw.close();
    }
}