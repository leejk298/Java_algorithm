import java.io.*;
import java.util.*;

/*
6 4 2
0100
1110
1000
0000
0111
0000
 */

public class 벽부수고이동2_백준 {
    static int N, M, K, res;    // 크기, 결과값
    static int[][] map; // 입력배열
    static boolean[][][] visited;   // 방문배열, Z: 부술 수 있는 횟수
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1 ,1};

    static class Node { // 내부 클래스
        int x, y, z, d; // 좌표, 부술 수 있는 횟수, 거리: 거리배열로 표현할 수 없음 => 겹침 => 객체로 표현

        public Node (int x, int y, int z, int d) {  // 파라미터 생성자
            this.x = x;
            this.y = y;
            this.z = z;
            this.d = d;
        }
    }

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 행
        M = Integer.parseInt(st.nextToken());   // 열
        K = Integer.parseInt(st.nextToken());   // 부술 수 있는 횟수
        res = Integer.MAX_VALUE;    // 최대값으로 초기화

        // 초기화
        map = new int[N][M];
        visited = new boolean[N][M][K + 1]; // 횟수만큼 표현하기 위해: K + 1

        for(int i = 0; i < N; i++) {    // 행
            char[] ch = bf.readLine().toCharArray();    // 문자배열

            for(int j = 0; j < M; j++)  // 열
                map[i][j] = ch[j] - '0';    // 입력배열 저장
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static boolean BFS(int x, int y, int z) {    // BFS

        Queue<Node> queue = new LinkedList<>(); // 큐

        queue.offer(new Node(x, y, z, 1));  // 시작점, 부순 횟수 0, 거리 1인 Node 객체 큐에 삽입
        visited[x][y][z] = true;    // 시작점부터 방문

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            Node now = queue.poll();    // 하나 꺼내어

            int nowX = now.x, nowY = now.y, nowZ = now.z, nowD = now.d; // 현재 노드

            if(nowX == N - 1 && nowY == M - 1) {    // 도착점에 도달하면
                res = Math.min(res, nowD); // 결과값 저장

                return true;    // true
            }

            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY][nowZ])  // 유효한지
                    continue;

                if(map[tmpX][tmpY] == 0) {  // 벽이 아니면
                    visited[tmpX][tmpY][nowZ] = true;   // 방문
                    queue.offer(new Node(tmpX, tmpY, nowZ, nowD + 1));  // 거리 + 1 갱신 후 큐에 삽입
                } else if(nowZ < K && !visited[tmpX][tmpY][nowZ + 1]) { // 벽이고 부술 수 있으면서 방문 가능하면
                    visited[tmpX][tmpY][nowZ + 1] = true;   // 방문
                    queue.offer(new Node(tmpX, tmpY, nowZ + 1, nowD + 1));  // 횟수 + 1, 거리 + 1 갱신 후 큐에 삽입
                }
            }
        }

        return false;   // 여기에 도달하면 도착점에 가지 못하는 것이므로 false
    }

    public static void main(String[] args) throws IOException {

       init();  // 초기화

       if(BFS(0, 0, 0)) // BFS, 도달 가능하면
           System.out.println(res); // 결과값 출력
       else // 도달 불가능하면
           System.out.println(-1);  // -1 출력
    }
}
