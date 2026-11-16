import java.io.*;
import java.util.*;

public class ACompositePermutation {

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
        while (t--> 0) {
            int n = r.nextInt();

            if ( n > 3) {
                if( n % 2 == 0) {
                    for(int i = n ; i >=1 ; i--) {
                        pw.print(i + " ");

                     }
                } else {
                    for(int i = n - 1 ; i >=1 ; i--) {
                        pw.print(i + " ");
                    }
                    pw.print(n);                    

                }
                pw.println();
            } else{
                pw.println(-1);
            }
            

            
        }

        pw.close();
    }
}