import java.util.*;
import java.io.*;


public class 출퇴근길_소프티어 {
    static int N, M, S, T;
    static List<Integer>[] A;
    static List<Integer>[] reverseA;
    static boolean[] visited;
    static boolean[] visitedS;
    static boolean[] visitedT;
    static boolean[] rVisitedS;
    static boolean[] rVisitedT;

    public static void init() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        A = new ArrayList[N + 1];
        reverseA = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
            reverseA[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            A[start].add(end);
            reverseA[end].add(start);
        }

        S = sc.nextInt();
        T = sc.nextInt();
    }

    public static void BFS(int v, int end, List<Integer>[] A) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(v);
        visited[v] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            if(now == end)
                break;

            for(int next : A[now]) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }

    public static void printCount() {
        int count = 0;

        for(int i = 1; i <= N; i++) {
            if(visitedS[i] && visitedT[i] && rVisitedS[i] && rVisitedT[i])
                count++;
        }

        System.out.println(count - 2);
    }

    public static void main(String args[]) {

        init();

        visited = new boolean[N + 1];
        BFS(S, T, A);
        visitedS = visited;

        visited = new boolean[N + 1];
        BFS(T, S, A);
        visitedT = visited;

        visited = new boolean[N + 1];
        BFS(S, T, reverseA);
        rVisitedS = visited;

        visited = new boolean[N + 1];
        BFS(T, S, reverseA);
        rVisitedT = visited;

        printCount();
    }
}