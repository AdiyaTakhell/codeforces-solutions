import java.io.*;
import java.util.*;

public class CBooksOnAShelf {

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 1 << 16);
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
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Random rnd = new Random();

    static void sort(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);
            int tmp = a[i]; a[i] = a[j]; a[j] = tmp;
        }
        Arrays.sort(a);
    }

    public static void main(String[] args) {
        int t = r.nextInt();
        while (t-- > 0) {
            int n = r.nextInt();
            int[] h = new int[n];
            for (int i = 0; i < n; i++) h[i] = r.nextInt();
            sort(h);

            int[] vals = new int[n];
            int[] cnt = new int[n];
            int m = 0;
            for (int i = 0; i < n; i++) {
                if (m > 0 && vals[m - 1] == h[i]) {
                    cnt[m - 1]++;
                } else {
                    vals[m] = h[i];
                    cnt[m] = 1;
                    m++;
                }
            }

            int k = 0;
            for (int i = 0; i < m; i++) k += Math.min(cnt[i], 2);

            StringBuilder sb = new StringBuilder();
            sb.append(k).append('\n');
            for (int i = 0; i < m - 1; i++) sb.append(vals[i]).append(' ');
            for (int i = 0; i < m - 1; i++)
                for (int j = 2; j < cnt[i]; j++) sb.append(vals[i]).append(' ');
            for (int j = 0; j < cnt[m - 1]; j++) sb.append(vals[m - 1]).append(' ');
            for (int i = m - 2; i >= 0; i--)
                if (cnt[i] >= 2) sb.append(vals[i]).append(' ');
            sb.append('\n');

            pw.print(sb);
        }

        pw.close();
    }
}