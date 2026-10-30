
import java.io.*;
import java.util.*;

public class AMaximizeOneMex {

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(
                new InputStreamReader(stream), 32768
            );
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

    static int calculateScore(int[] a, int k) {
        int n = a.length;

        boolean[] seen = new boolean[n + 1];
        int[] frequency = new int[n + 1];

        int mex = 0;

        for (int value : a) {
            seen[value] = true;

            while (seen[mex]) {
                mex++;
            }

            frequency[mex]++;
        }

        int count = 0;

        for (int value = n; value >= 0; value--) {
            count += frequency[value];

            if (count >= k) {
                return value;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int t = r.nextInt();

        while (t-- > 0) {
            int n = r.nextInt();
            int k = r.nextInt();

            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = r.nextInt();
            }

            int originalScore = calculateScore(a, k);
            int bestScore = originalScore;

            int bestI = -1;
            int bestJ = -1;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {

                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;

                    int score = calculateScore(a, k);

                    if (score > bestScore) {
                        bestScore = score;
                        bestI = i;
                        bestJ = j;
                    }

                    
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }

            if (bestI == -1) {
                pw.println(-1);
            } else {
                pw.println((bestI + 1) + " " + (bestJ + 1));
            }
        }

        pw.close();
    }
}
