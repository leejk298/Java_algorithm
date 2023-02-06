import java.util.*;
import java.io.*;

public class 게임개발_위상정렬_054 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken()); // 크기
        int build[] = new int[N + 1]; // 자기 건물 비용
        int res[] = new int[N + 1]; // 자기 건물 만들기 위한 이전 비용
        int indegree[] = new int[N + 1]; // 진입차수
        ArrayList<Integer>[] A = new ArrayList[N + 1]; // 인접리스트

        for (int i = 1; i <= N; i++) // 크기만큼
            A[i] = new ArrayList<Integer>(); // 인접리스트 구현

        for (int i = 1; i <= N; i++) { // 크기만큼
            st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

            build[i] = Integer.parseInt(st.nextToken()); // 자기 건물 비용 설정

            while (true) {
                int t = Integer.parseInt(st.nextToken()); // 한 줄 스트링

                if (t == -1) // -1 이면 while문 종료, i++
                    break;

                A[t].add(i); // 인접리스트 연결
                indegree[i]++; // 진입차수 갱신
            }
        }

        Queue<Integer> queue = new LinkedList<>(); // 큐

        for (int i = 1; i <= N; i++) // 크기만큼
            if (indegree[i] == 0) // 진입차수가 0 이면
                queue.add(i); // 큐에 저장

        while (!queue.isEmpty()) { // 큐가 비어있지않으면
            int now = queue.poll(); // 하나 꺼내어

            for (int next : A[now]) { // 현재 노드의 인접리스트를 탐색하여
                indegree[next]--; // 인접리스트들의 진입차수 1씩 감소

                res[next] = Math.max(res[next], res[now] + build[now]); // 자기 건물 이전 비용 갱신

                if (indegree[next] == 0) // 인접리스트의 진입차수가 0 이면
                    queue.add(next); // 큐에 저장
            }
        }

        for (int i = 1; i <= N; i++) // 크기만큼
            System.out.println(res[i] + build[i]); // 총 비용 출력
    }
}
