import java.util.*;
import java.io.*;


public class 거리합구하기_소프티어 {
    static ArrayList<cNode> A[];    // 그래프
    static boolean visited[];   // 방문배열
    static long D[];    // 거리배열
    static long subTreeSize[];  // 서브트리
    static int N;   // 크기

    static class cNode {
        int v;
        int w;
        public cNode (int v, int w) {
            this.v = v;
            this.w = w;
        }
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

    public static void main(String args[]) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        N = Integer.parseInt(bf.readLine());    // 크기
        A = new ArrayList[N + 1];   // 연결리스트 초기화

        for(int i = 1; i <= N; i++) // 크기만큼
            A[i] = new ArrayList<>();   // 구현

        for(int i = 0; i < N - 1; i++) {    // N - 1
            StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int S = Integer.parseInt(st.nextToken());   // 시작
            int E = Integer.parseInt(st.nextToken());   // 도착
            int W = Integer.parseInt(st.nextToken());   // 가중치

            A[S].add(new cNode(E, W));  // 양방향
            A[E].add(new cNode(S, W));
        }

        // 초기화
        subTreeSize = new long[N + 1];
        D = new long[N + 1];
        visited = new boolean[N + 1];
        dfs1(1);

        visited = new boolean[N + 1];
        dfs2(1);

        for(int i = 1; i <= N; i++)
            System.out.println(D[i]);
    }
}