import java.util.*;

/*
3 7
32 62
42 68
12 98
95 13
97 25
93 37
79 27
75 19
49 47
67 17
 */

public class 뱀과사다리게임_백준 {
    static int N, M, res;   // 크기, 결과값
    static int[] map;   // 맵
    static int[] visited;   // 방문배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 사다리
        M = sc.nextInt();   // 뱀

        // 초기화, 1 ~ 100
        map = new int[101];
        visited = new int[101];

        for(int i = 1; i <= 100; i++)   // 1 ~ 100
            map[i] = i; // 각 숫자로 맵 저장

        for(int i = 0; i < N; i++) {    // 사다리 개수만큼
            int s = sc.nextInt();   // 작은 값
            int e = sc.nextInt();   // 큰 값

            map[s] = e; // 이동 저장
        }

        for(int i = 0; i < M; i++) {    // 뱀 개수만큼
            int s = sc.nextInt();   // 큰 값
            int e = sc.nextInt();   // 작은 값

            map[s] = e; // 이동 저장
        }
    }

    public static void BFS() {  // BFS

        Queue<Integer> queue = new LinkedList<>();  // 큐

        queue.offer(1); // 1부터 시작, 시작점 큐에 삽입
        visited[1] = 0; // 0회

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int now = queue.poll(); // 하나 꺼내어

            if(map[now] == 100) {   // 100에 도착하면
                res = visited[100]; // 몇 번만에 방문했는지 저장

                break;  // while 탈출
            }

            for(int i = 1; i <= 6; i++) {   // 주사위
                int next = now + i; // 다음 숫자

                if(next > 100)  // 100 초과하면 건너뛰기
                    continue;

                if(visited[map[next]] == 0) {   // 0이면, 방문하지 않았으면
                    visited[map[next]] = visited[now] + 1;  // 횟수 1 증가
                    queue.offer(map[next]); // 큐에 삽입
                }
            }
        }
    }

    public static void main(String[] args) {

        init(); // 초기화

        BFS();  // BFS

        System.out.println(res);    // 결과값 출력
    }
}
