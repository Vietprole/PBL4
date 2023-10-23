package test1;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {
    static final int maxn = 1000;
    static final int maxf = 1000000000;
    static int[][] a = new int[maxn][maxn];
    static int[] f = new int[maxn];
    static int[] trace = new int[maxn];
    static boolean[] checkt2 = new boolean[maxn];

    public static String mydijkstra(int s, int e) throws IOException {
        int n, m;
        Scanner inp = new Scanner(new File("D:/tai xuong/input.txt"));
        n = inp.nextInt();
        m = inp.nextInt();
        for (int i = 1; i <= n; i++) {
            Arrays.fill(a[i], -1);
        }
        for (int i = 1; i <= m; i++) {
            int u = inp.nextInt();
            int v = inp.nextInt();
            int w = inp.nextInt();
            a[u][v] = w;
            a[v][u] = w;
        }
        inp.close();
        for (int i = 1; i <= n; i++) {
            f[i] = maxf;
            checkt2[i] = true;
            trace[i] = 0;
        }
        f[s] = 0;
        trace[s] = 0;
        int v = s, fmin;
        while (v != e) {
            // Find v
            fmin = maxf;
            for (int i = 1; i <= n; i++) {
                if (checkt2[i] && fmin > f[i]) {
                    fmin = f[i];
                    v = i;
                }
            }
            if (fmin == maxf)
                break;
            // Remove v from T2
            checkt2[v] = false;
            // Optimize the vertices in T2
            for (int i = 1; i <= n; i++) {
                if (a[v][i] > 0 && f[i] > f[v] + a[v][i]) {
                    f[i] = f[v] + a[v][i];
                    trace[i] = v;
                }
            }
        }

        if (f[e] == maxf) {
            System.out.println("NO PATH");
            return "NO PATH";
        } else {
            //System.out.println(f[e]);
            StringBuilder result = new StringBuilder();
            result.append(f[e]).append("\n");
            int[] path = new int[maxn];
            int d = 0;
            d++;
            path[d] = e;
            while (trace[e] != 0) {
                e = trace[e];
                d++;
                path[d] = e;
            }
           
            for (int i = d; i > 0; i--) {
                result.append(path[i]).append(" ");
            }
            //System.out.print(result);
            return result.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        String pathResult = mydijkstra(1, 4);
        System.out.println( pathResult);
    }
}
