import java.io.*;
import java.util.*;

public class AHeyItSMeSouvlakity {

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
    }

    static InputReader r = new InputReader(System.in);
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = r.nextInt();
        while (t-- > 0) {
            int n = r.nextInt();
            String s = r.next();

            int count = 0;
            int first = -1;
            int last = -1;

            
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    count++;
                    if (first == -1) {
                        first = i;
                    }
                    last = i;
                }
            }

            
            if (count == 1) {
                pw.println(0);
            } else if (count == 2) {
                pw.println(1);
            } else {
                pw.println(last - first);
            }
        }

        pw.close();
    }
}