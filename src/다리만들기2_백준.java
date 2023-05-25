import java.util.*;

/*
7 8
0 0 0 1 1 0 0 0
0 0 0 1 1 0 0 0
1 1 0 0 0 0 1 1
1 1 0 0 0 0 1 1
1 1 0 0 0 0 0 0
0 0 0 0 0 0 0 0
1 1 1 1 1 1 1 1
 */

public class 다리만들기2_백준 {
    static int N, M, sNum;  // 크기, 섬 이름
    static int[][] map; // 맵
    static boolean[][] visited; // 방문배열
    static List<List<int[]>> sumList;   // 전체 섬리스트
    static List<int[]> mList;   // 각각의 섬리스트
    static int[] parent;    // 대표노드
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};
    static PriorityQueue<Edge> pq;  // 엣지리스트, 우선순위 큐

    static class Edge implements Comparable<Edge> { // 엣지 클래스
        int s, e, w;    // 정점, 가중치

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge e) {  // 메소드 재정의
            return this.w - e.w;    // 오름차순 정렬
        }
    }

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 행
        M = sc.nextInt();   // 열

        // 맵 만들기
        map = new int[N][M];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                map[i][j] = sc.nextInt();
    }

    public static boolean isValidPos(int x, int y) {    // 좌표가 유효한지
        return (x >= 0 && x < N && y >= 0 && y < M);
    }

    public static void addNode(int i, int j, Queue<int[]> queue) {  // 섬 추가하기

        map[i][j] = sNum;   // 섬 이름
        visited[i][j] = true;   // 방문여부 갱신
        mList.add(new int[] {i, j});    // 해당 섬리스트에 좌표 저장
        queue.offer(new int[] {i, j});  // 큐에 삽입
    }

    public static void BFS(int i, int j) {  // BFS

        Queue<int[]> queue = new LinkedList<>();    // 큐
        mList = new ArrayList<>();  // 각각의 섬리스트

        queue.offer(new int[] {i, j});  // 큐에 시작점 삽입
        mList.add(new int[] {i, j});    // 부분 섬리스트에 저장
        visited[i][j] = true;   // 방문여부 갱신
        map[i][j] = sNum;   // 섬 이름

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어

            int nowX = now[0], nowY = now[1];   // 좌표
            for(int k = 0; k < 4; k++) {    // 4방향
                int tmpX = nowX + dx[k], tmpY = nowY + dy[k];   // 다음 좌표

                while(isValidPos(tmpX, tmpY)) { // 좌표가 유효한 동안

                    if(visited[tmpX][tmpY] || map[tmpX][tmpY] == 0) // 방문했거나 바다이면 while 종료
                        break;

                    // 방문하지 않았고 섬인 경우
                    addNode(tmpX, tmpY, queue); // 섬 추가

                    if(k == 0)  // 상
                        tmpX--;
                    if(k == 1)  // 하
                        tmpX++;
                    if(k == 2)  // 좌
                        tmpY--;
                    if(k == 3)  // 우
                        tmpY++;
                }
            }
        }
    }

    public static void makeSum() {  // 섬 만들기

        // 초기화
        sNum = 1;
        visited = new boolean[N][M];
        sumList = new ArrayList<>();    // 전체 섬리스트
        for(int i = 0; i < N; i++) {    // 행
            for(int j = 0; j < M; j++) {    // 열
                if(!visited[i][j] && map[i][j] != 0) {  // 방문하지 않았고 바다가 아니면
                    BFS(i, j);  // BFS
                    sNum++; // 섬 이름
                    sumList.add(mList); // 전체 섬리스트에 부분 섬리스트 저장
                }
            }
        }
    }

    public static void makeBridge() {   // 다리 만들기

        pq = new PriorityQueue<>(); // 우선순위 큐

        for(int i = 0; i < sumList.size(); i++) {   // 전체 섬리스트 크기만큼
            List<int[]> now = sumList.get(i);   // 하나씩 꺼내서

            for(int j = 0; j < now.size(); j++) {   // 해당 섬리스트 크기만큼
                int nowX = now.get(j)[0];   // x 좌표
                int nowY = now.get(j)[1];   // y 좌표
                int nowS = map[nowX][nowY]; // 섬 이름

                for(int k = 0; k < 4; k++) {    // 4방향
                    int tmpX = nowX + dx[k], tmpY = nowY + dy[k];   // 다음 좌표
                    int length = 0; // 다리 길이

                    while(isValidPos(tmpX, tmpY)) { // 좌표가 유효한 동안

                        if(map[tmpX][tmpY] == nowS) // 자신의 섬과 같으면 while 종료
                            break;

                        else {  // 다른 섬인 경우
                            if(map[tmpX][tmpY] == 0)    // 바다일 때
                                length++;   // 다리 길이 증가

                            else {  // 섬일 때
                                if(length > 1)  // 다리 길이가 1보다 큰 경우
                                    pq.offer(new Edge(nowS, map[tmpX][tmpY], length));  // 다리 만들기
                                break;  // 1 이하인 경우 while 종료
                            }
                        }

                        if(k == 0)  // 상
                            tmpX--;
                        if(k == 1)  // 하
                            tmpX++;
                        if(k == 2)  // 좌
                            tmpY--;
                        if(k == 3)  // 우
                            tmpY++;
                    }
                }
            }
        }
    }

    public static int find(int a) { // find

        if(a == parent[a])
            return a;

        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {    // 합집합

        a = find(a);
        b = find(b);

        if(a != b)
            parent[b] = a;
    }

    public static void Kruskal() {  // 크루스칼

        // 초기화
        parent = new int[sNum];
        for(int i = 1; i < sNum; i++)
            parent[i] = i;

        int useEdge = 1, cost = 0;  // 사용 엣지 수, 최소비용
        while(!pq.isEmpty()) {  // 우선순위 큐가 비어있지 않으면
            Edge now = pq.poll();   // 하나 꺼내서

            if(find(now.s) != find(now.e)) {    // 서로 다른 대표노드이면
                union(now.s, now.e);    // 합집합

                cost += now.w;  // 최소비용 갱신
                useEdge++;  // 사용 엣지수 증가
            }
        }

        if(useEdge == sNum - 1) // MST: N - 1개 사용했으면
            System.out.println(cost);   // 최소비용 출력
        else    // 아니면
            System.out.println(-1); // -1 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        makeSum();  // 섬 만들기

        makeBridge();   // 다리 만들기

        Kruskal();  // 크루스칼, 최소비용 출력
    }
}
