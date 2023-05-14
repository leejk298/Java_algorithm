import java.util.*;

/*
2
3 2
1 3
2 3
4 4
1 2
2 3
3 4
4 2
 */

public class 이분그래프_백준 {
    static int N, M, K; // 크기
    static List<Integer>[] A;   // 인접리스트
    static boolean[] visited;   // 방문배열
    static int[] check; // 이분 체크배열
    static boolean isEven;  // 이분그래프

    public static void init(Scanner sc) {   // 초기화

        N = sc.nextInt();   // 노드
        M = sc.nextInt();   // 엣지

        // 초기화
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        check = new int[N + 1];
        isEven = true;

        for(int i = 1; i <= N; i++) // 인접리스트 구현
            A[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {    // 엣지 개수만큼
            int start = sc.nextInt();   // 시작
            int end = sc.nextInt();     // 끝

            A[start].add(end);  // 무방향
            A[end].add(start);
        }
    }

    public static void DFS(int v) { // DFS

        visited[v] = true;  // 방문여부 갱신

        for(int i : A[v]) { // 인접리스트 순회
            if(!visited[i]) {   // 방문하지 않았으면
                check[i] = (check[v] + 1) % 2;  // 체크배열 표시
                DFS(i); // DFS
            }

            else if(check[i] == check[v]) // 방문한 경우, 체크배열값이 같으면
                isEven = false; // 이분그래프가 아님
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    // 입력

        K = sc.nextInt();   // 테스트 개수

        for(int t = 0; t < K; t++) {    // 테스트 개수만큼

            init(sc);   // 초기화

            for(int i = 1; i <= N; i++) {   // 노드 개수만큼
                if(isEven)  // 이분그래프이면
                    DFS(i); // DFS
                else    // 아니면
                    break;  // 반복문 종료
            }

            if(isEven)  // 이분그래프이면
                System.out.println("YES");  // YES 출력
            else    // 아니면
                System.out.println("NO");   // NO 출력
        }
    }
}
