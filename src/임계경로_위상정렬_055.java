import java.util.*;
import java.io.*;

public class 임계경로_위상정렬_055 {
    static class wNode { // wNode 클래스
        int node; // 노드
        int w; // 가중치

        wNode(int node, int w) { // 파라미터 생성자
            this.node = node;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력버퍼

        int N = Integer.parseInt(bf.readLine()); // 노드
        int M = Integer.parseInt(bf.readLine()); // 엣지

        int indegree[] = new int[N + 1]; // 진입차수
        int res[] = new int[N + 1]; // 임계경로
        ArrayList<wNode>[] A = new ArrayList[N + 1]; // 인접리스트
        ArrayList<wNode>[] reverseA = new ArrayList[N + 1]; // 역방향 인접리스트

        for (int i = 1; i <= N; i++) { // 노드 개수만큼
            A[i] = new ArrayList<wNode>(); // 인접리스트 구현
            reverseA[i] = new ArrayList<wNode>();
        }

        for (int i = 0; i < M; i++) { // 엣지 개수만큼
            StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

            int S = Integer.parseInt(st.nextToken()); // 시작
            int E = Integer.parseInt(st.nextToken()); // 끝
            int W = Integer.parseInt(st.nextToken()); // 가중치

            A[S].add(new wNode(E, W)); // 인접리스트 구현
            reverseA[E].add(new wNode(S, W));
            indegree[E]++; // 진입차수 갱신
        }

        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        int start = Integer.parseInt(st.nextToken()); // 출발 도시
        int end = Integer.parseInt(st.nextToken()); // 도착 도시

        Queue<Integer> queue = new LinkedList<>(); // 큐
        queue.add(start); // 출발 도시부터 시작하여

        while (!queue.isEmpty()) { // 큐가 비어있지않으면
            int now = queue.poll(); // 하나 꺼내어

            for (wNode next : A[now]) { // 해당 노드의 인접리스트들 순회
                indegree[next.node]--; // 인접리스트 전부 진입차수 갱신
                res[next.node] = Math.max(res[next.node], res[now] + next.w); // 임계경로 갱신 => 최대값으로

                if (indegree[next.node] == 0) // 진입차수가 0 이면
                    queue.add(next.node); // 큐에 저장
            }
        }

        int cnt = 0; // 도시 방문 횟수
        boolean visited[] = new boolean[N + 1]; // 방문배열

        queue = new LinkedList<>(); // 큐
        queue.add(end); // 도착 도시부터 시작하여 역방향으로
        visited[end] = true; // 방문여부 갱신
        while (!queue.isEmpty()) { // 큐가 비어있지않으면
            int now = queue.poll(); // 하나 꺼내어

            for (wNode next : reverseA[now]) { // 해당 노드의 인접리스트들 순회
                if (res[next.node] + next.w == res[now]) { // 1분도 쉬지않은 도로 체크
                    cnt++;

                    if (visited[next.node] == false) { // 방문한 적이 없으면
                        visited[next.node] = true; // 방문 여부 갱신 후
                        queue.add(next.node); // 큐에 추가

                        // 방문한 적이 있으면 건너뜀 -> 도로 중복 카운트 방지
                    }
                }
            }
        }

        System.out.println(res[end]); // 임계경로 값 출력
        System.out.println(cnt); // 도로 개수 출력
    }
}
