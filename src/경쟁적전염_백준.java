import java.util.*;

/*
3 3
1 0 2
0 0 0
3 0 0
2 3 2
 */

public class 경쟁적전염_백준 {
    static int N, K, S, r, c;   // 크기
    static int[][] map; // 맵
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};
    static List<Node> list; // Node 리스트
    static Queue<Node> queue;  // 큐

    static class Node { // Node 클래스
        int x, y, virus, time;

        public Node(int x, int y, int virus, int time) {
            this.x = x;
            this.y = y;
            this.virus = virus;
            this.time = time;
        }
    }

    public static void init() { // 초기화
        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기
        K = sc.nextInt();   // 바이러스

        // 초기화
        map = new int[N][N];
        list = new ArrayList<>();
        queue = new LinkedList<>();

        // 맵, 리스트 저장
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();

                if(map[i][j] != 0)
                    list.add(new Node(i, j, map[i][j], 0));
            }
        }

        S = sc.nextInt();   // 시간
        r = sc.nextInt();   // 좌표
        c = sc.nextInt();
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= N);
    }

    public static void BFS() {  // BFS
        while(!queue.isEmpty()) {   // 큐가 비어있지않으면
            Node now = queue.poll();    // 하나 꺼내어

            if(now.time == S)   // 종료
                return;

            int nowX = now.x, nowY = now.y; // 좌표
            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY))   // 유효한지
                    continue;

                if(map[tmpX][tmpY] == 0) {  // 0 이면
                    map[tmpX][tmpY] = now.virus;    // 감염
                    queue.offer(new Node(tmpX, tmpY, now.virus, now.time + 1)); // 큐에 삽입
                }
            }
        }
    }

    public static void main(String[] args) {

        init(); // 초기화

        Collections.sort(list, (o1, o2) -> {    // 바이러스 정렬
            return o1.virus - o2.virus;
        });

        for(Node node : list)   // 큐에 삽입
            queue.offer(node);

        BFS();  // BFS

        System.out.println(map[r - 1][c - 1]);  // 값 출력
    }
}
