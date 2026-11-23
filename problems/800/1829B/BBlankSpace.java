import java.io.*;
import java.util.*;

public class BBlankSpace {

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
            int currentZeros = 0;
            int maxZeros = 0;
            for (int i = 0; i < n; i++) {
                int num = r.nextInt();

                if (num == 0) {
                    currentZeros++;
                    maxZeros = Math.max(maxZeros, currentZeros);
                } else {
                    currentZeros = 0;
                }

            }
            pw.println(maxZeros);

        }
        ;

        pw.close();
    }
}