import java.io.*;
import java.util.*;

public class CBigXor {

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

    // Highest bit of c_i = i ^ (i << 1) for i <= 2*10^5 is < 2^19,
    // so MAXBIT = 20 (bits 0..20) is enough.
    static final int MAXBIT = 20;

    public static void main(String[] args) {
        int noTsts = r.nextInt();

        while (noTsts-- > 0) {
            int n = r.nextInt();
            int W = (n + 63) / 64;

            long[] basisVal = new long[MAXBIT + 1];
            long[][] basisBits = new long[MAXBIT + 1][];

            
            for (int i = 1; i <= n; i++) {
                long v = (long) i ^ ((long) i << 1);
                long tmp = v;
                int b;

                
                for (b = MAXBIT; b >= 0; b--) {
                    if (((tmp >> b) & 1L) == 0) continue;
                    if (basisVal[b] == 0) break;
                    tmp ^= basisVal[b];
                }

                if (b < 0) continue; 

                
                long[] bits = new long[W];
                int idx = i - 1;
                bits[idx >> 6] |= 1L << (idx & 63);

                long cur = v;
                for (int b2 = MAXBIT; b2 >= 0; b2--) {
                    if (((cur >> b2) & 1L) == 0) continue;
                    if (basisVal[b2] == 0) break;
                    cur ^= basisVal[b2];
                    long[] bb = basisBits[b2];
                    for (int j = 0; j < W; j++) {
                        bits[j] ^= bb[j];
                    }
                }

                basisVal[b] = tmp;
                basisBits[b] = bits;
            }

            
            long X;
            switch (n % 4) {
                case 0:  X = n;         break;
                case 1:  X = 1;         break;
                case 2:  X = n + 1L;    break;
                default: X = 0;         break;
            }

           
            long curX = X;
            boolean[] used = new boolean[MAXBIT + 1];

            for (int b = MAXBIT; b >= 0; b--) {
                if (basisVal[b] != 0) {
                    long cand = curX ^ basisVal[b];
                    if (cand > curX) {
                        curX = cand;
                        used[b] = true;
                    }
                }
            }

            
            long[] finalBits = new long[W];
            for (int b = 0; b <= MAXBIT; b++) {
                if (used[b] && basisBits[b] != null) {
                    long[] bb = basisBits[b];
                    for (int j = 0; j < W; j++) {
                        finalBits[j] ^= bb[j];
                    }
                }
            }

            // Output answer
            for (int i = 0; i < n; i++) {
                int bit = (int) ((finalBits[i >> 6] >> (i & 63)) & 1L);
                if (i > 0) pw.print(' ');
                pw.print(bit);
            }
            pw.println();
        }

        pw.close();
    }
}