import java.util.*;
import java.io.*;

/*
6 4
0100
1110
1000
0000
0111
0000
 */
public class 벽부수고이동_백준 {
    static int N, M;    // 크기
    static int[][] map, D;  // 입력, 거리배열
    static boolean[][][] visited;   // 방문배열: 3차원으로 선언해 이동할 수 있는지 체크
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    static class Node { // 노드 클래스
        int x, y, z;    // 매개 변수

        public Node(int x, int y, int z) {  // 파라미터 생성자
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 행
        M = Integer.parseInt(st.nextToken());   // 열

        // 초기화
        map = new int[N][M];
        visited = new boolean[N][M][2]; // z 크기를 2로 하여 0이면 부수기 X, 1이면 부수기 O
        D = new int[N][M];

        for(int i = 0; i < N; i++) {    // 행
            char[] ch = bf.readLine().toCharArray();    // 문자배열로 저장

            for(int j = 0; j < M; j++)  // 열
                map[i][j] = ch[j] - '0';    // 숫자배열로 저장
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지

        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static boolean BFS(int x, int y, int z) {    // BFS

        Queue<Node> queue = new LinkedList<>(); // 큐

        queue.offer(new Node(x, y, z)); // 시작점 추가
        visited[x][y][z] = true;    // 시작점 방문 여부 갱신
        D[x][y] = 1;    // 거리 1부터 시작

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            Node now = queue.poll();    // 하나 꺼내어

            int nowX = now.x, nowY = now.y, nowZ = now.z;   // 현재 노드

            if(nowX == N - 1 && nowY == M - 1)  // 도착점에 도달하면
                return true;    // true 리턴

            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 노드

                if(isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY][nowZ])  // 유효한지
                    continue;

                if(map[tmpX][tmpY] == 0) {  // 0이면 => 그냥 이동 가능
                    visited[tmpX][tmpY][nowZ] = true;   // 방문 여부 갱신
                    D[tmpX][tmpY] = D[nowX][nowY] + 1;  // 거리 갱신
                    queue.offer(new Node(tmpX, tmpY, nowZ));    // 큐에 삽입
                } else if(nowZ == 1) {  // 1이고 부술 수 있으면 => 이동 가능
                    visited[tmpX][tmpY][nowZ] = true;
                    D[tmpX][tmpY] = D[nowX][nowY] + 1;
                    queue.offer(new Node(tmpX, tmpY, nowZ - 1));    // 부술 수 있는 횟수 -1
                }
            }
        }

        return false;   // 여기로 오면 도착점에 도달하지 못한 것이므로 false 리턴
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        if(BFS(0, 0, 1))    // BFS, 도달가능하면
            System.out.println(D[N - 1][M - 1]);    // 거리 출력
        else    // 도달 불가능하면
            System.out.println(-1); // -1 출력
    }
}
