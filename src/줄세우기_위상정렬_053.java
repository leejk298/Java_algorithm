import java.util.*;

public class 줄세우기_위상정렬_053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력

        int N = sc.nextInt(); // 노드
        int M = sc.nextInt(); // 엣지
        ArrayList<Integer>[] A = new ArrayList[N + 1]; // 인접리스트
        int indegree[] = new int[N + 1]; // 진입차수 배열

        for (int i = 1; i <= N; i++) // 노드 개수만큼
            A[i] = new ArrayList<Integer>(); // 인접리스트 구현

        for (int i = 0; i < M; i++) { // 엣지 개수만큼
            int S = sc.nextInt(); // 시작
            int E = sc.nextInt(); // 끝
            A[S].add(E); // 방향 그래프
            indegree[E]++; // 끝노드 진입차수 1 증가시킴
        }

        Queue<Integer> queue = new LinkedList<Integer>(); // 큐
        for (int i = 1; i <= N; i++) // 노드 개수만큼
            if (indegree[i] == 0) // 진입차수가 0이면
                queue.offer(i); // 큐에 저장

        while (!queue.isEmpty()) { // 큐가 비어있지않으면
            int now = queue.poll(); // 하나 꺼내어
            System.out.print(now + " "); // 출력

            for (int i : A[now]) { // 꺼낸 노드의 인접리스트 탐색
                indegree[i]--; // 해당 노드들 진입차수 1씩 감소

                if (indegree[i] == 0) // 0 이면
                    queue.offer(i); // 큐에 저장
            }
        }
    }
}
