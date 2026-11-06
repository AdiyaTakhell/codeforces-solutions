import java.io.*;
import java.util.*;

public class BIntroductionToTheNicheInternet {

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try { tokenizer = new StringTokenizer(reader.readLine()); }
                catch (IOException e) { throw new RuntimeException(e); }
            }
            return tokenizer.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
    }

    public static void main(String[] args) {
        InputReader r = new InputReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int t = r.nextInt();
        while (t-- > 0) {
            int n = r.nextInt();
            int k = r.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = r.nextInt();
            Arrays.sort(a);

            // count of max element
            int cntMax = 0;
            for (int i = n - 1; i >= 0 && a[i] == a[n - 1]; i--) cntMax++;

            if (cntMax > k) {
                pw.println("NO");
                continue;
            }

            pw.println("YES");
            StringBuilder sb = new StringBuilder();

            // k largest elements in increasing order -> all pleasant
            for (int i = n - k; i < n; i++) sb.append(a[i]).append(' ');
            // remaining elements in decreasing order -> none pleasant
            for (int i = n - k - 1; i >= 0; i--) sb.append(a[i]).append(' ');

            sb.setLength(sb.length() - 1);
            pw.println(sb);
        }
        pw.close();
    }
}