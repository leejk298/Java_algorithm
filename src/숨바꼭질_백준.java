import java.util.*;

/*
5 17
 */

public class 숨바꼭질_백준 {
    static int N, K;    // 시작, 도착
    static int[] visited;   // 방문배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 시작
        K = sc.nextInt();   // 도착

        visited = new int[100001];  // 초기화
    }

    public static int BFS() {   // BFS

        Queue<Integer> queue = new LinkedList<>();  // 큐

        queue.offer(N); // 시작점 큐에 삽입
        visited[N] = 1; // 시작점 1부터 시작

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int now = queue.poll(); // 하나 꺼내어

            for(int i = 0; i < 3; i++) {    // -1, +1, *2 연산 수행
                int next;   // 다음 숫자

                if(i == 0)  // -1
                    next = now - 1;
                else if(i == 1) // +1
                    next = now + 1;
                else    // *2
                    next = now * 2;

                if(next == K)   // 같으면
                    return visited[now];    // 몇 번만에 도착했는지

                if(next >= 0 && next < 100001 && visited[next] == 0) {  // 유효한 값이고 방문한 적이 없으면
                    visited[next] = visited[now] + 1;   // 횟수 갱신
                    queue.offer(next);  // 큐에 삽입
                }
            }
        }

        return 0;   // 비정상 값
    }

    public static void main(String[] args) {

        init(); // 초기화

        if(N >= K)  // 시작이 도착보다 크거나 같으면
            System.out.println(N - K);  // -1 연산만 가능하므로 빼기
        else    // 도착이 크면
            System.out.println(BFS());  // BFS
    }
}
