import java.util.*;
import java.io.*;


public class 거리합구하기_소프티어 {
    static ArrayList<cNode> A[];
    static boolean visited[];
    static long D[];
    static long subTreeSize[];
    static int N;

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        A = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            A[S].add(new cNode(E, W));
            A[E].add(new cNode(S, W));
        }

        subTreeSize = new long[N + 1];
        D = new long[N + 1];
        visited = new boolean[N + 1];
        dfs1(1);

        visited = new boolean[N + 1];
        dfs2(1);

        for(int i = 1; i <= N; i++)
            System.out.println(D[i]);
    }

    static void dfs1(int v) {
        subTreeSize[v] = 1;
        visited[v] = true;
        for(cNode i: A[v]) {
            int child = i.v;
            int weight = i.w;

            if(!visited[child]) {
                dfs1(child);
                D[v] = D[v] + D[child] + subTreeSize[child] * weight;
                subTreeSize[v] += subTreeSize[child];
            }
        }
    }

    static void dfs2(int v) {
        visited[v] = true;
        for(cNode i : A[v]) {
            int child = i.v;
            int weight = i.w;
            if(!visited[child]) {
                D[child] = D[v] + weight * (N - 2 * subTreeSize[child]);
                dfs2(child);
            }
        }
    }

    static class cNode {
        int v;
        int w;
        public cNode (int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}