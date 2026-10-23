import java.io.*;
import java.util.*;

public class ABeautifulMatrix {

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

        int i = 0;
        int j = 0;

        outerLoop:
        while (i < 5) {
            j = 0;

            while (j < 5) {
                int input = r.nextInt();

                if (input == 1) {
                    break outerLoop;
                }

                j++;
            }

            i++;
        }

        int result = Math.abs(i - 2) + Math.abs(j - 2);

        pw.println(result);
        pw.close();
    }
}

