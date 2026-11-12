import java.io.*;
import java.util.*;

public class AThreePiles {

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
            int a = r.nextInt();
            int b = r.nextInt();
            int c = r.nextInt();

            int total = a + b + c;
            if (total % 3 != 0) {
                pw.println("NO");
                continue;
            }

            int target = total / 3;

            boolean valid = Math.abs(a - target) <= 1
                         && Math.abs(b - target) <= 1
                         && Math.abs(c - target) <= 1
                         && !(a == target && b == target && c == target);

            pw.println(valid ? "YES" : "NO");
        }

        pw.close();
    }
}