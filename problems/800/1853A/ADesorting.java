
import java.io.*;
import java.util.*;

public class ADesorting {

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

            int prev = r.nextInt();

            int min = Integer.MAX_VALUE;
            boolean notSorted = false;

            for (int i = 1; i < n; i++) {

                int curr = r.nextInt();

                if (prev > curr) {
                    notSorted = true;
                } else if (!notSorted) {
                    int distance = curr - prev;
                    min = Math.min(min, distance);
                }

                prev = curr;
            }

            int result = (min / 2) + 1;

            pw.println(notSorted ? 0 : result);
        }

        pw.close();
    }
}
