import java.io.*;
import java.util.*;

public class BStubbornPen {

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
            String s = r.next();
            int prev = 0;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                char natural = (i % 2 ==0) ? 'R' : 'B';
                int cur = (s.charAt(i) == natural) ? 0 : 1;
                if(cur != prev) {
                    ans++;
                }
                prev = cur;                
                
            }
            pw.println(ans);
            
        }
        

        pw.close();
    }
}