import java.io.*;
import java.util.*;

public class AHelpfulMaths {

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
    String s = r.next();
    int[] freq = new int[3];

    for (int i = 0; i < s.length(); i++) {
        char current = s.charAt(i);
        if (current == '1') {
            freq[0]++;
        } else if (current == '2') {
            freq[1]++;
        } else if (current == '3') {
            freq[2]++;
        }
    }

    StringBuilder sb = new StringBuilder();

    for (int q = 0; q < 3; q++) {
        for (int i = 0; i < freq[q]; i++) {
            if (sb.length() > 0) {
                sb.append('+');
            }
            sb.append(q + 1);
        }
    }

    pw.println(sb.toString());
    pw.close();
}
}