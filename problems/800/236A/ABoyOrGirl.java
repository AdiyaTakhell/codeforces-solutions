import java.io.*;
import java.util.*;

public class ABoyOrGirl {

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
        
        boolean[] seen = new boolean[26];
       String userName = r.next();
       int distint = 0;
       for(int i = 0 ; i < userName.length() ; i++) {
        int index = userName.charAt(i) - 'a';
        if(!seen[index]) {
            seen[index] = true;
            distint++;
        }
       }
           
        pw.println(distint % 2 !=0 ? "IGNORE HIM!" : "CHAT WITH HER!" ) ;
        pw.close();
    }
}