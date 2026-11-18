import java.io.*;
import java.util.*;

public class BSwapAndDelete {

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
            String s = r.next();
            int n = s.length();
            int zero = 0, one = 0;

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    one++;
                } else {
                    zero++;
                }
            }

            int placed = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') {
                    if (one > 0) {
                        one--;
                        placed++;
                    } else {
                        break;
                    }
                } else {
                    if (zero > 0) {
                        zero--;
                        placed++;
                    } else {
                        break;
                    }
                }
            }

            pw.println(n - placed);
        }

        pw.close();
    }
}