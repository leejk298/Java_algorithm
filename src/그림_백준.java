import java.util.*;
/*
6 5
1 1 0 1 1
0 1 1 0 0
0 0 0 0 0
1 0 1 1 1
0 0 1 1 1
0 0 1 1 1
 */
public class 그림_백준 {
    static int N, M, count; // 크기, 넓이
    static int[][] map; // 맵
    static boolean[][] visited; // 방문배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};
    static List<Integer> answer;    // 결과리스트

    public static void init() { // 초기화
        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 행
        M = sc.nextInt();   // 열

        // 초기화
        answer = new ArrayList<>();
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++)  // 행
            for(int j = 0; j < M; j++)  // 열
                map[i][j] = sc.nextInt();   // 저장
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }
    
    public static void BFS(int x, int y) {  // BFS
        Queue<int[]> queue = new LinkedList<>();    // 큐

        queue.offer(new int[] {x, y});  // 시작점 삽입
        visited[x][y] = true;   // 방문여부 갱신
        count++;    // 개수 카운트

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어

            int nowX = now[0], nowY = now[1];   // 좌표
            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY])    // 유효한지
                    continue;

                if(map[tmpX][tmpY] == 1) {  // 1 이면
                    visited[tmpX][tmpY] = true; // 방문여부 갱신
                    count++;    // 개수 카운트
                    queue.offer(new int[] {tmpX, tmpY});    // 큐에 삽입
                }
            }

        }
    }

    public static void main(String[] args) {

        init(); // 초기화

        for(int i = 0; i < N; i++) {    // 행
            for(int j = 0; j < M; j++) {    // 열
                if(map[i][j] == 1 && !visited[i][j]) {  // 갈 수 있으면
                    BFS(i, j);  // BFS
                    answer.add(count);  // 결과리스트에 추가
                    count = 0;  // 초기화
                }
            }
        }

        System.out.println(answer.size());  // 총 개수 출력

        Collections.sort(answer);   // 정렬

        if(answer.size() == 0)  // 없으면
            System.out.println(0);  // 넓이 0
        else    // 있으면
            System.out.println(answer.get(answer.size() - 1));  // 최대 넓이 출력
    }
}