import java.io.*;
import java.util.*;

public class CIKnowAboutAMillionThings {

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
                    String line = reader.readLine();
                    if (line == null) return null;
                    tokenizer = new StringTokenizer(line);
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
            int odd = 0;
            for (int i = 0; i < n; i++) {
                int x = r.nextInt();
                if ((x & 1) == 1) odd++;
            }
            int even = n - odd;

            boolean larpityWins = (even == 0 && odd == 3) || (even == 1 && odd == 1);

            pw.println(larpityWins ? "Larpity" : "Moggity");
        }
        pw.close();
    }
}