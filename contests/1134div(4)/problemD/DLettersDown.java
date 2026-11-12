import java.io.*;
import java.util.*;

public class DLettersDown {

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
            String s = r.next();

            int[] diff = new int[27];
            for (int i = 0; i < n / 2; i++) {
                int x = s.charAt(i) - 'a';
                int y = s.charAt(n - 1 - i) - 'a';
                if (x == y) continue;
                int lo = Math.min(x, y);
                int hi = Math.max(x, y);
                diff[lo + 1]++;
                diff[hi + 1]--;
            }

            int result = 0;
            int cur = 0;
            for (int x = 1; x < 26; x++) {
                cur += diff[x];
                if (cur > 0) result++;
            }

            pw.println(result);
        }

        pw.close();
    }
}