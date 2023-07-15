import java.util.*;
import java.io.*;

/*
5 4
3 1
3 2
4 3
5 3
 */

public class 효율적인해킹_백준 {
    static int N, M;    // 크기
    static int[] arr;   // 해킹 가능 배열
    static ArrayList<Integer>[] A;  // 인접리스트
    static boolean[] visited;   // 방문배열
    static StringBuilder sb;    // 결과문자열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 정점 개수
        M = Integer.parseInt(st.nextToken());   // 엣지 개수

        // 초기화
        A = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++)
            A[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {    // 엣지 개수만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int S = Integer.parseInt(st.nextToken());   // 시작
            int E = Integer.parseInt(st.nextToken());   // 도착

            A[S].add(E);    // 단반향
        }
    }

    public static void DFS(int v) { // DFS

        if(visited[v])  // 방문한 적이 있으면
            return; // 건너뛰기

        // 방문한 적이 없으면
        visited[v] = true;  // 방문

        for(int i = 0; i < A[v].size(); i++) {  // 인접리스트 크기만큼
            int next = A[v].get(i); // 다음 노드

            if(!visited[next]) {    // 방문한 적이 없으면
                arr[next]++;    // 해킹가능 카운트
                DFS(next);  // 재귀콜, DFS
            }
        }
    }

    public static void findMaxCount() { // 가능한 최대 해킹 개수

        arr = new int[N + 1];   // 초기화

        for(int i = 1; i <= N; i++) {   // 정점 개수만큼
            visited = new boolean[N + 1];   // 방문배열 초기화
            DFS(i); // DFS
        }

        int max = 0;    // 최대값
        for(int i = 1; i <= N; i++) // 정점 개수만큼
            if(max < arr[i])    // 최대값 구하기
                max = arr[i];

        sb = new StringBuilder();   // 결과 문자열 만들기
        for(int i = 1; i <= N; i++) // 정점 개수만큼
            if(arr[i] == max)   // 최대값과 같으면
                sb.append(i + " "); // 결과 저장
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        findMaxCount(); // 최대 개수 찾기

        System.out.println(sb); // 결과 출력
    }
}
