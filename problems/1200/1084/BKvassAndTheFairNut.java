import java.io.*;
import java.util.*;

public class BKvassAndTheFairNut {

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
        long n = r.nextLong();
        long s = r.nextLong();
        long sum = 0;
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long num = r.nextLong();
            min = Math.min(min, num);
            sum += num;
        }
        if (sum < s) {
            pw.println(-1);
        } else {
            long answer = Math.min(min, (sum - s) / n);
            pw.println(answer);
        }

        pw.close();
    }
}