import java.io.*;
import java.util.*;

public class BSequenceGame {

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
        while (t-->0) {
            int n = r.nextInt();
            int[] b = new int[n];
            for(int i = 0 ; i < n ; i++) {
                b[i]  = r.nextInt();
            }
            List<Integer> result = new ArrayList<>();
            result.add(b[0]);
            for(int i = 1 ; i < n; i++) {
                if(b[i-1] <= b[i]) {
                    result.add(b[i]);
                } else {
                    result.add(1);
                    result.add(b[i]);
                }                                                  
            }
            pw.println(result.size());
            for(int i= 0 ; i < result.size(); i++) {
                pw.print(result.get(i) + " ");
            }
            pw.println();
            
        }

        pw.close();
    }
}