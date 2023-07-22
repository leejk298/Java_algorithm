import java.util.*;

public class 복습3_0720 {
    static int N, M, count; // 크기, 개수
    static Set<Integer> set;    // 해시셋
    static List<Integer> list;  // 결과리스트
    static int[][] map; // 입력배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited; // 방문배열

    public static void init(String[] maps) {    // 초기화

        N = maps.length;    // 행
        M = maps[0].length();   // 열
        count = 0;  // 개수

        // 초기화
        set = new HashSet<>();
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++)  // 행
            for(int j = 0; j < M; j++)  // 열
                map[i][j] = maps[i].charAt(j) - '0';    // 정수형으로 저장
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static void BFS(int x, int y) {  // BFS

        Queue<int[]> queue = new LinkedList<>();    // 큐

        queue.offer(new int[] {x, y});  // 시작점 추가
        visited[x][y] = true;   // 방문여부 갱신
        count++;    // 개수 카운트

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어

            int nowX = now[0], nowY = now[1];   // 현재 좌표
            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY])    // 유효한지
                    continue;

                if(map[tmpX][tmpY] == 1) {  // 땅이면
                    visited[tmpX][tmpY] = true; // 방문여부 갱신
                    count++;    // 개수 카운트
                    queue.offer(new int[] {tmpX, tmpY});    // 큐에 삽입
                }
            }
        }
    }

    public static void findIsland() {   // 섬 넓이 찾기

        for(int i = 0; i < N; i++) {    // 행
            for(int j = 0; j < M; j++) {    // 열
                if(!visited[i][j] && map[i][j] == 1) {  // 방문한 적이 없고 땅이면
                    BFS(i, j);  // BFS
                    set.add(count); // 해시셋에 저장, 중복 제거
                    count = 0;  // 개수 초기화
                }
            }
        }

        list = new ArrayList<>(set);    // 셋을 이용해 리스트 생성, 정렬 위해
        Collections.sort(list); // 정렬
    }

    public static int[] solution(String[] maps) {

        init(maps); // 초기화

        findIsland();   // 섬 넓이 찾기

        return list.stream().mapToInt(i -> i).toArray();    // 정수형 리스트 -> 배열 변환 후 리턴
    }

    public static void main(String[] args) {

        String[] maps = {"111010", "110110", "000000", "110111"};

        System.out.println(Arrays.toString(solution(maps)));
    }
}
