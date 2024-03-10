import java.util.*;
import java.io.*;

/*
5 17
 */

public class 숨바꼭질3_백준 {
    static int N, K, res;   // 입력값, 결과값
    static final int max = 100001;  // 최대 구간값
    static boolean[] visited;   // 방문배열

    static class Node { // 노드 클래스
        int num, count; // 값, 횟수

        public Node(int num, int count) {   // 파라미터 생성자
            this.num = num;
            this.count = count;
        }
    }

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 수빈
        K = Integer.parseInt(st.nextToken());   // 동생

        visited = new boolean[max]; // 방문배열 초기화
        res = Integer.MAX_VALUE;    // 결과값을 최대값으로 초기화
    }

    public static void BFS() {  // BFS

        Queue<Node> queue = new LinkedList<>(); // 큐

        queue.offer(new Node(N, 0));    // 큐에 시작점 삽입

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            Node now = queue.poll();    // 하나 꺼내어

            int nowNum = now.num, nowCount = now.count; // 현재 값과 횟수
            visited[nowNum] = true; // 방문 여부 갱신

            if(nowNum == K) // 동생을 찾으면
                res = Math.min(res, nowCount);  // 최소값 저장

            if(nowNum * 2 < max && !visited[nowNum * 2])    // 순간이동
                queue.offer(new Node(nowNum * 2, nowCount));    // 2배, 횟수는 그대로

            if(nowNum + 1 < max && !visited[nowNum + 1])    // 걷기 + 1
                queue.offer(new Node(nowNum + 1, nowCount + 1));

            if(nowNum - 1 >= 0 && !visited[nowNum - 1]) // 걷기 - 1
                queue.offer(new Node(nowNum - 1, nowCount + 1));
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        BFS();  // BFS

        System.out.println(res);    // 결과값 출력
    }
}
