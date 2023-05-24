import java.util.*;

/*
5 17
 */

public class 숨바꼭질3_백준 {
    static int N, T, res;   // 크기, 결과값
    static final int max = 100000;  // 최대 100,000
    static boolean[] visited;   // 방문배열

    static class Node { // 노드 클래스
        int data, count;    // 숫자, 횟수

        public Node(int data, int count) {  // 생성자
            this.data = data;
            this.count = count;
        }
    }

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 주어진 숫자
        T = sc.nextInt();   // 타겟 숫자
        res = Integer.MAX_VALUE;    // 최소값 찾기위해 최대로 초기화

        visited = new boolean[max + 1]; // 초기화
    }

    public static void BFS() {  // BFS

        Queue<Node> queue = new LinkedList<>(); // 큐
        queue.offer(new Node(N, 0));    // 시작점 큐에 삽입

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            Node now = queue.poll();    // 하나 꺼내어
            visited[now.data] = true;   // 방문여부 갱신

            if(now.data == T)   // 찾으면
                res = Math.min(res, now.count); // 최소값으로 설정

            if(now.data * 2 <= max && !visited[now.data * 2])   // 2배
                queue.offer(new Node(now.data * 2, now.count)); // 순간이동

            if(now.data + 1 <= max && !visited[now.data + 1])   // + 1
                queue.offer(new Node(now.data + 1, now.count + 1)); // 횟수 + 1

            if(now.data - 1 >= 0 && !visited[now.data - 1]) // - 1
                queue.offer(new Node(now.data - 1, now.count + 1));
        }
    }

    public static void main(String[] args) {

        init(); // 초기화

        BFS();  // BFS

        System.out.println(res);    // 결과값 출력
    }
}
