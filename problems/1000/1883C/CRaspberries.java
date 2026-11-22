import java.io.*;
import java.util.*;

public class CRaspberries {

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
            int even = 0;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                int num = r.nextInt();
                int cost = (k - num % k) % k; 
                min = Math.min(min, cost);
                if ((num & 1) == 0) even++;
            }

            int ans = min;
            if (k == 4) {
                ans = Math.min(ans, 2 - Math.min(even, 2));
            }
            pw.println(ans);
        }

        pw.close();
    }
}