import java.io.*;
import java.util.*;

public class AUnitArray {

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
        while (t -- > 0) {
            int n = r.nextInt();
            int neg = 0;
            for(int i = 0 ; i < n ; i++ ) {
                int num = r.nextInt();
                if(num == -1) {
                    neg++;
                }

            }
            int res = 0;
            int pos = n - neg;
            int mid = (n +1) / 2;
            if ( mid > pos) {
                int flips = mid - pos;
                neg-=flips;
                pos+=flips;
                res+=flips;
            }       
            if(neg % 2 != 0) {
                res++;
            }
            pw.println(res);
            
        }

        pw.close();
    }
}