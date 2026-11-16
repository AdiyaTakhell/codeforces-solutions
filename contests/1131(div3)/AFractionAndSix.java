
import java.io.*;
import java.util.*;

public class AFractionAndSix {

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
            int m = r.nextInt();

            String p = r.next();
            String q = r.next();

            int[] freq = new int[26];

            for (int i = 0; i < n; i++) {
                freq[p.charAt(i) - 'a']++;
            }

            for (int i = 0; i < m; i++) {
                freq[q.charAt(i) - 'a']--;
            }

            String target = "six";

            for (int i = 0; i < target.length(); i++) {
                freq[target.charAt(i) - 'a']--;
            }

            boolean possible = true;

            for (int i = 0; i < 26; i++) {
                if (freq[i] != 0) {
                    possible = false;
                    break;
                }
            }

            pw.println(possible ? "YES" : "NO");
        }

        pw.close();
    }
}
