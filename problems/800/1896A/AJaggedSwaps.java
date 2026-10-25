import java.io.*;
import java.util.*;

public class AJaggedSwaps {

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
            int first = r.nextInt();
            for(int i = 1 ; i < n ; i++) {
               r.nextInt();
            }           
            pw.println(first == 1 ? "YES" : "NO");       
            
        }        
 
        pw.close();   

    }
}