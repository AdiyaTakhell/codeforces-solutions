
import java.io.*;
import java.util.*;

public class BFrogsJump {

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(
                new InputStreamReader(stream), 32768
            );
            tokenizer = null;
        }

        public String next() {
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

    static int solve(int n, String top, String bottom) {
        int topCount = 0;
        int bottomCount = 0;

        for (int i = 0; i < n; i++) {
            if (top.charAt(i) == 'f') {
                topCount++;
            }

            if (bottom.charAt(i) == 'f') {
                bottomCount++;
            }
        }

        int difference = Math.abs(topCount - bottomCount);
        String majorityRow = topCount > bottomCount ? top : bottom;

        int pairs = 0;

        for (int i = 0; i + 1 < n; ) {
            if (majorityRow.charAt(i) == 'f'
                    && majorityRow.charAt(i + 1) == 'f') {
                pairs++;
                i += 2;
            } else {
                i++;
            }
        }

        int usablePairs = Math.min(pairs, difference / 2);
        int keptFrogs = 2 * Math.min(topCount, bottomCount)
                + 2 * usablePairs;

        return topCount + bottomCount - keptFrogs;
    }

    public static void main(String[] args) {
        int t = r.nextInt();

        while (t-- > 0) {
            int n = r.nextInt();
            String top = r.next();
            String bottom = r.next();

            pw.println(solve(n, top, bottom));
        }

        pw.close();
    }
}
