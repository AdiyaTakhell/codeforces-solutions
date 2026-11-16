import java.io.*;
import java.util.*;

public class EArithmeticSubarray {

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

    static long mix(long x) {
        x += 0x9e3779b97f4a7c15L;
        x = (x ^ (x >>> 30)) * 0xbf58476d1ce4e5b9L;
        x = (x ^ (x >>> 27)) * 0x94d049bb133111ebL;
        return x ^ (x >>> 31);
    }

    public static void main(String[] args) {
        int t = r.nextInt();
        while (t-- > 0) {
            int n = r.nextInt();
            int k = r.nextInt();
            long[] a = new long[n + 1];
            for (int i = 1; i <= n; i++)
                a[i] = r.nextLong();

            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n && j - i <= k + 1; j++) {
                    if ((a[j] - a[i]) % (j - i) == 0)
                        cnt++;
                }
            }
            long[] arr = new long[2 * cnt];
            int sz = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n && j - i <= k + 1; j++) {
                    long diff = a[j] - a[i];
                    int len = j - i;
                    if (diff % len != 0)
                        continue;
                    long d = diff / len;
                    long b = a[i] - d * i;
                    long id = mix(mix(d) + b) >>> 18;
                    arr[sz++] = (id << 18) | i;
                    arr[sz++] = (id << 18) | j;
                }
            }

            Arrays.sort(arr, 0, sz);

            int best = 1;
            int start = 0;
            while (start < sz) {
                long id = arr[start] >> 18;
                int end = start;
                while (end < sz && (arr[end] >> 18) == id)
                    end++;

                int m = 0;
                int[] pos = new int[end - start];
                for (int p = start; p < end; p++) {
                    int x = (int) (arr[p] & ((1 << 18) - 1));
                    if (m == 0 || pos[m - 1] != x)
                        pos[m++] = x;
                }

                int l = 0;
                for (int rr = 0; rr < m; rr++) {
                    while ((pos[rr] - pos[l] + 1) - (rr - l + 1) > k)
                        l++;
                    best = Math.max(best, rr - l + 1);
                }
                start = end;
            }

            pw.println(Math.min(n, k + best));
        }
        pw.close();
    }
}