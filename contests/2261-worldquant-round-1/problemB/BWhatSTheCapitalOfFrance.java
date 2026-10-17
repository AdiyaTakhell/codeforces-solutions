import java.io.*;
import java.util.*;

public class BWhatSTheCapitalOfFrance {

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
            int[] a = new int[n];
            int M = Integer.MIN_VALUE; // maximum
            int L = Integer.MAX_VALUE; // minimum
            for (int i = 0; i < n; i++) {
                a[i] = r.nextInt();
                if (a[i] > M) M = a[i];
                if (a[i] < L) L = a[i];
            }

            
            if (L == M) {
                pw.println(M);
                continue;
            }

            int ans = M;
           
            for (int p = 30; p >= 0; p--) {
                if ((M & (1 << p)) != 0) {
                   
                    long mask = (1L << (p + 1)) - 1;
                    long T_p = (M & ~mask) | ((1L << p) - 1);
                    
                    if (T_p >= L) {
                        ans = M | ((1 << p) - 1);
                        break;
                    }
                }
            }
            pw.println(ans);
        }
        pw.close();
    }
}