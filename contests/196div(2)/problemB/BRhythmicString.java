import java.io.*;
import java.util.*;

public class BRhythmicString {

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
    }

    static InputReader r = new InputReader(System.in);
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = r.nextInt();

        while (t-- > 0) {
            int n = r.nextInt();
            long[] a = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = r.nextLong();
            }

            int answer = n;

            for (int i = 0; i < n; i++) {
                long p = a[i];
                int keep = 0;

                for (int j = 0; j < n; j++) {
                    if (a[j] % p == 0) {
                        keep++;
                    }
                }

                answer = Math.min(answer, n - keep);
            }

            pw.println(answer);
        }

        pw.close();
    }
}