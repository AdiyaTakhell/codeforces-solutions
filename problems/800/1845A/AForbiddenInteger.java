
import java.io.*;
import java.util.*;

public class AForbiddenInteger {

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
            int n = r.nextInt();
            int k = r.nextInt();
            int x = r.nextInt();

            if (x != 1) {
                pw.println("YES");
                pw.println(n);

                for (int i = 0; i < n; i++) {
                    pw.print("1 ");
                }
                pw.println();

            } else {
                if (k == 1) {
                    pw.println("NO");

                } else if (n % 2 == 0) {
                    pw.println("YES");
                    pw.println(n / 2);

                    for (int i = 0; i < n / 2; i++) {
                        pw.print("2 ");
                    }
                    pw.println();

                } else if (k >= 3) {
                    pw.println("YES");
                    pw.println((n - 3) / 2 + 1);

                    for (int i = 0; i < (n - 3) / 2; i++) {
                        pw.print("2 ");
                    }

                    pw.println("3");

                } else {
                    pw.println("NO");
                }
            }
        }

        pw.close();
    }
}
