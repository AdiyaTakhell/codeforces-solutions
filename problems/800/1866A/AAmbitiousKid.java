//https://codeforces.com/problemset/problem/1866/A

import java.io.*;
import java.util.*;

public class AAmbitiousKid {

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
        int n = r.nextInt();
        int m = Integer.MAX_VALUE;
        for(int i = 0 ; i < n; i++) {
            int x = r.nextInt();

            if ( x == 0) {
                pw.println(0);
                pw.close();
            } else {
                m = Math.min(m, Math.abs(x));

            }  
             
        }
        pw.println(m);
        pw.close();
    }
}