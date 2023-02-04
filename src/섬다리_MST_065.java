import java.io.*;
import java.util.*;

public class 섬다리_MST_065 {
    static int dx[] = { -1, 0, 1, 0 }; // 4 방향: 좌 하 우 상
    static int dy[] = { 0, 1, 0, -1 };
    static int N, M, sNum; // 행, 열, 섬이름
    static int map[][]; // 지도
    static boolean visited[][]; // 방문배열
    static int parent[]; // 대표노드
    static ArrayList<int[]> mList; // 각각의 섬 리스트
    static ArrayList<ArrayList<int[]>> sumList; // 전체 섬 리스트
    static PriorityQueue<sEdge> pq; // 엣지리스트

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열

        // 맵 만들기
        map = new int[N][M]; // 맵 초기화
        for (int i = 0; i < N; i++) { // 행 만큼
            st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

            for (int j = 0; j < M; j++) // 열 만큼
                map[i][j] = Integer.parseInt(st.nextToken()); // 값 저장
        }

        // 섬 만들기
        visited = new boolean[N][M]; // 방문배열 초기화
        sNum = 1; // 섬이름 1부터 시작 => 크기: N + 1
        sumList = new ArrayList<ArrayList<int[]>>(); // 전체 섬 리스트 구현
        for (int i = 0; i < N; i++) { // 행
            for (int j = 0; j < M; j++) { // 열
                if (visited[i][j] == false && map[i][j] != 0) { // 방문하지않았고 값이있으면
                    BFS(i, j); // 해당 좌표로 하나의 섬 만들기
                    sNum++; // 섬이름 갱신
                    sumList.add(mList); // 하나의 섬을 전체 섬리스트에 추가
                }
            }
        }

        // 다리 만들기
        pq = new PriorityQueue<>(); // 엣지리스트 구현
        for (int i = 0; i < sumList.size(); i++) { // 전체 섬 중
            ArrayList<int[]> now = sumList.get(i); // 섬 하나씩 꺼내어

            for (int j = 0; j < now.size(); j++) { // 해당 섬의 크기만큼
                int nowX = now.get(j)[0]; // x 좌표
                int nowY = now.get(j)[1]; // y 좌표
                int nowS = map[nowX][nowY]; // 해당 좌표의 값

                for (int k = 0; k < 4; k++) { // 4 방향
                    int tmpX = dx[k];
                    int tmpY = dy[k];
                    int length = 0; // 다리 길이

                    // 좌표가 유효한 동안 반복
                    while (nowX + tmpX >= 0 && nowX + tmpX < N && nowY + tmpY >= 0 && nowY + tmpY < M) {
                        if (map[nowX + tmpX][nowY + tmpY] == nowS) // 같은 섬이면
                            break; // 다리를 못만듬

                        else if (map[nowX + tmpX][nowY + tmpY] != 0) { // 같은 섬이 아니고 바다도 아니면
                            if (length > 1) // 다리 길이가 1 보다 크면 엣지리스트에 추가
                                pq.add(new sEdge(nowS, map[nowX + tmpX][nowY + tmpY], length)); // 다리 만듬
                            break; // 1 보다 작거나 같으면 다리 X
                        } else // 바다인 경우
                            length++; // 다리길이 증가

                        // 해당 방향으로 DFS처럼 계속해서 다리 놓기
                        if (tmpX < 0)
                            tmpX--;
                        else if (tmpX > 0)
                            tmpX++;
                        else if (tmpY < 0)
                            tmpY--;
                        else if (tmpY > 0)
                            tmpY++;
                    }
                }
            }
        }

        parent = new int[sNum]; // 대표노드 초기화
        for (int i = 0; i < parent.length; i++)
            parent[i] = i; // 해당 인덱스로 설정

        int useEdge = 1; // 사용한 엣지 개수 => 노드 1부터 시작이므로 똑같이 맞춰줌
        int res = 0; // 총 비용

        while (!pq.isEmpty()) { // 엣지리스트가 비어있지않으면 반복
            sEdge now = pq.poll(); // 하나 꺼내어

            if (find(now.S) != find(now.E)) { // 대표노드가 다르면
                union(now.S, now.E); // 합집합

                res += now.W; // 총 비용 갱신
                useEdge++; // 사용한 엣지 수 갱신
            }
        }

        if (useEdge == sNum - 1) // 엣지를 N - 1 개 사용했으면 => MST 특징
            System.out.println(res); // 출력
        else // 아니면 - 1 출력
            System.out.println(-1);
    }

    private static void union(int a, int b) { // 합집합
        a = find(a);
        b = find(b);

        if (a != b)
            parent[b] = a;
    }

    private static int find(int a) { // find
        if (a == parent[a])
            return a;

        return parent[a] = find(parent[a]);
    }

    private static void BFS(int i, int j) { // BFS => 섬 만들기
        Queue<int[]> queue = new LinkedList<>(); // 큐
        mList = new ArrayList<>(); // 하나의 섬 리스트 구현
        int start[] = { i, j }; // 시작 좌표

        queue.add(start); // 시작 좌표 큐에 삽입
        mList.add(start); // 하나의 섬 리스트에 삽입
        visited[i][j] = true; // 해당 좌표 방문배열 갱신
        map[i][j] = sNum; // 해당 좌표 지도에서 섬으로 저장

        while (!queue.isEmpty()) { // 큐가 비어있지않으면 반복
            int now[] = queue.poll(); // 하나 꺼내어
            int x = now[0]; // x 좌표
            int y = now[1]; // y 좌표

            for (int k = 0; k < 4; k++) { // 4 방향
                int tmpX = dx[k];
                int tmpY = dy[k];

                // 좌표가 유효한 동안 반복
                while (x + tmpX >= 0 && x + tmpX < N && y + tmpY >= 0 && y + tmpY < M) {
                    // 방문한 적이 없고 바다가 아니면
                    if (!visited[x + tmpX][y + tmpY] && map[x + tmpX][y + tmpY] != 0) {
                        addNode(x + tmpX, y + tmpY, queue); // 섬 추가
                    } else // 방문한 적이 있거나 바다인 경우
                        break; // while문 탈출

                    // 해당 좌표의 방향으로 DFS처럼 계속 탐색하여 섬 추가
                    if (tmpX < 0)
                        tmpX--;
                    else if (tmpX > 0)
                        tmpX++;
                    else if (tmpY < 0)
                        tmpY--;
                    else if (tmpY > 0)
                        tmpY++;
                }
            }
        }
    }

    private static void addNode(int i, int j, Queue<int[]> queue) { // 섬 추가
        map[i][j] = sNum; // 해당 좌표에 섬이름 저장
        visited[i][j] = true; // 방문배열 갱신
        int tmp[] = { i, j }; // 해당 좌표

        mList.add(tmp); // 하나의 섬리스트에 삽입
        queue.add(tmp); // 큐에 삽입
    }
}

class sEdge implements Comparable<sEdge> { // 엣지리스트 => Comparable 인터페이스 구현 => compareTo()메소드 재정의
    int S, E, W;

    public sEdge(int S, int E, int W) {
        this.S = S;
        this.E = E;
        this.W = W;
    }

    @Override
    public int compareTo(sEdge E) { // 오버라이딩
        return this.W - E.W; // 오름차순
    }
}