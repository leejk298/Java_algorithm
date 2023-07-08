import java.io.*;
import java.util.*;

/*
5 3
0 0 1 0 0
0 0 2 0 1
0 1 2 0 0
0 0 1 0 0
0 0 0 0 2
 */

public class 치킨배달_백준 {
    static int N, M, res;   // 크기, 결과값
    static int[][] map; // 입력배열
    static ArrayList<Pos> chickenList;  // 치킨집 리스트
    static ArrayList<Pos> houseList;    // 집 리스트
    static boolean[] visited;   // 치킨집 방문배열

    static class Pos {  // 좌표 클래스
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 크기
        M = Integer.parseInt(st.nextToken());   // 치킨집 개수
        res = Integer.MAX_VALUE;    // 결과값

        // 초기화
        map = new int[N][N];
        chickenList = new ArrayList<>();
        houseList = new ArrayList<>();

        for(int i = 0; i < N; i++) {    // 행
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            for (int j = 0; j < N; j++) {   // 열
                map[i][j] = Integer.parseInt(st.nextToken());   // 입력배열 저장

                if(map[i][j] == 1)  // 1 이면
                    houseList.add(new Pos(i, j));   // 집
                if(map[i][j] == 2)  // 2 이면
                    chickenList.add(new Pos(i, j)); // 치킨집
            }
        }

        visited = new boolean[chickenList.size()];  // 방문배열 초기화
    }

    public static void DFS(int depth, int index) {  // DFS, 브루트포스

        if(depth == M) {    // 개수만큼 뽑으면
            int distance = 0;   // 총 거리
            for(int i = 0; i < houseList.size(); i++) { // 집 리스트 개수만큼
                int sum = Integer.MAX_VALUE;    // 각 거리 합

                for(int j = 0; j < chickenList.size(); j++) {   // 치킨집 리스트 개수만큼
                    if(visited[j]) {    // 방문한 치킨집이면
                        int d = Math.abs(houseList.get(i).x - chickenList.get(j).x) +
                                Math.abs(houseList.get(i).y - chickenList.get(j).y);    // 치킨 거리 계산

                        sum = Math.min(sum, d); // 최소 거리
                    }
                }

                distance += sum;    // 총 거리 갱신
            }

            res = Math.min(res, distance);  // 최소값 저장

            return; // 완전 탐색하기 위해 함수리턴
        }

        // 도달하지 못하면
        for(int i = index; i < chickenList.size(); i++) {   // 해당 치킨집부터 총 개수만큼
            if(!visited[i]) {   // 방문한 적이 없으면
                visited[i] = true;  // 방문
                DFS(depth + 1, i + 1);  // 재귀콜
                visited[i] = false; // 리턴되면 방문 여부 갱신
            }
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        DFS(0, 0);  // DFS, 브루트포스

        System.out.println(res);    // 최소값 출력
    }
}
