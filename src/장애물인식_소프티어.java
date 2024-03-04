import java.util.*;
import java.io.*;

/*
7
1110111
0110101
0110101
0000100
0110000
0111110
0110000
*/

public class 장애물인식_소프티어 {
    static int N, oNum; // 크기, 장애물 번호
    static int[] dx = {0, -1, 0, 1};    // 4방향
    static int[] dy = {-1, 0, 1, 0};
    static boolean[][] visited; // 방문배열
    static int[][] map; // 입력배열
    static List<List<int[]>> obsList;   // 전체의 장애물 리스트
    static List<int[]> oList;   // 장애물의 좌표리스트

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 크기

        map = new int[N][N];    // 입력배열 초기화
        for (int i = 0; i < N; i++) {   // 행
            String str = bf.readLine(); // 한 줄
            char[] ch = str.toCharArray();  // 문자형 배열로

            for (int j = 0; j < N; j++) {   // 열
                map[i][j] = ch[j] - '0';    // 정수형 배열로 저장
            }
        }
    }

    public static void BFS(int i, int j) {  // BFS

        Queue<int[]> queue = new LinkedList<>();    // 큐
        oList = new ArrayList<int[]>(); // 좌표 리스트

        oList.add(new int[]{i, j}); // 시작점 리스트에 저장
        queue.offer(new int[]{i, j});   // 시작점 큐에 삽입

        map[i][j] = oNum;   // 장애물 번호 지정
        visited[i][j] = true;   // 방문

        while (!queue.isEmpty()) {  // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어

            int x = now[0], y = now[1];    // 현재 좌표
            for (int k = 0; k < 4; k++) {   // 4방향
                int tmpX = dx[k], tmpY = dy[k]; // 다음 좌표

                while (x + tmpX >= 0 && x + tmpX < N && y + tmpY >= 0 && y + tmpY < N) {    // 좌표가 유효한 동안
                    if (map[x + tmpX][y + tmpY] != 0 && !visited[x + tmpX][y + tmpY]) { // 장애물이 아니고 방문한 적도 없으면
                        addNode(x + tmpX, y + tmpY, queue); // 해당 좌표로 추가
                    } else  // 둘 중 하나만 아니라도
                        break;  // while 종료
                }

                if (tmpX > 0)   // 방향대로 쭉 DFS
                    tmpX++;
                if (tmpX < 0)
                    tmpX--;
                if (tmpY > 0)
                    tmpY++;
                if (tmpY < 0)
                    tmpY--;
            }
        }
    }

    public static void addNode(int i, int j, Queue<int[]> queue) {  // 추가

        map[i][j] = oNum;   // 장애물 번호 지정
        visited[i][j] = true;   // 방문여부 갱신

        oList.add(new int[]{i, j}); // 좌표리스트에 저장
        queue.offer(new int[]{i, j});   // 큐에 삽입
    }

    public static void makeObstacleList() {  // 장애물 리스트 만들기

        visited = new boolean[N][N];    // 방문배열 초기화
        oNum = 1;   // 장애물 번호 1번부터
        obsList = new ArrayList<List<int[]>>(); // 전체 장애물 리스트

        for (int i = 0; i < N; i++) {   // 행
            for (int j = 0; j < N; j++) {   // 열
                if (map[i][j] != 0 && !visited[i][j]) { // 장애물이 아니고 방문한 적도 없으면
                    BFS(i, j);  // BFS

                    oNum++; // 번호 1증가
                    obsList.add(oList); // 전체 리스트에 해당 장애물의 좌표리스트 저장
                }
            }
        }

        obsList.sort((List<int[]> o1, List<int[]> o2) -> o1.size() - o2.size());    // 크기가 작은 순으로 정렬
    }

    public static void printObstacleList() { // 장애물 리스트 출력

        System.out.println(obsList.size()); // 총 장애물 집합 개수 출력

        for (int i = 0; i < obsList.size(); i++)    // 크기만큼
            System.out.println(obsList.get(i).size());  // 해당 장애물 개수 출력
    }

    public static void main(String args[]) throws IOException {

        init(); // 초기화

        makeObstacleList();  // 장애물 리스트 만들기

        printObstacleList(); // 장애물 리스트 출력
    }

}