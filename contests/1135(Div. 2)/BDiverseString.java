import java.io.*;
import java.util.*;

public class BDiverseString {

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
            String s = r.next();

            int ones = 0;
            for (int i = 0; i < s.length(); i++) {
                char current = s.charAt(i);
                if (current == '1') {
                    ones++;

                }
            }
            int zeros = n - ones;
            int minority = Math.min(zeros, ones);
            int remaining = Math.max(0, minority - k);

            int majoriy = n - remaining;

            long ans = 1L
                    + (long) majoriy * (majoriy + 1) / 2
                    + (long) remaining * (remaining + 1) / 2;

            pw.println(ans);

        }

        pw.close();
    }
}