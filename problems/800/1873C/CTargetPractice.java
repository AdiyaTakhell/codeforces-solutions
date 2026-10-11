//https://codeforces.com/problemset/problem/1873/C

import java.io.*;
import java.util.*;

public class CTargetPractice {

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

            char[][] grid = new char[10][10];

            // Read the 10 x 10 grid
            for (int i = 0; i < 10; i++) {
                grid[i] = r.next().toCharArray();
            }

            int sum = 0;

           
            for (int i = 0; i < 5; i++) {

                int count = 0;

                
                for (int j = i; j < 10 - i; j++) {
                    if (grid[i][j] == 'X') {
                        count++;
                    }
                }

                
                for (int j = i + 1; j < 10 - i; j++) {
                    if (grid[j][i] == 'X') {
                        count++;
                    }
                }

                for (int j = i + 1; j < 10 - i; j++) {
                    if (grid[9 - i][j] == 'X') {
                        count++;
                    }
                }

                for (int j = i + 1; j < 9 - i; j++) {
                    if (grid[j][9 - i] == 'X') {
                        count++;
                    }
                }

                count *= i + 1;
                sum += count;
            }

            pw.println(sum);
        }

        pw.close();
    }
}