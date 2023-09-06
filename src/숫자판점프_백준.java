import java.io.*;
import java.util.*;

/*
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
1 1 1 2 1
1 1 1 1 1
 */

public class 숫자판점프_백준 {
    static String[][] map;  // 입력배열
    static HashSet<String> hashSet; // 해시셋, 중복제거
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    static class Node { // 내부 클래스
        int x, y;   // 좌표
        String s;   // 문자열

        public Node(int x, int y, String s) {   // 파라미터 생성자
            this.x = x;
            this.y = y;
            this.s = s;
        }
    }

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        // 초기화
        map = new String[5][5];
        hashSet = new HashSet<>();

        for(int i = 0; i < 5; i++)  // 행
            map[i] = bf.readLine().split(" ");  // 공백 기준으로 문자열 나눠서 입력배열 저장
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= 5 || y < 0 || y >= 5);
    }

    public static void BFS(Node v) {    // BFS

        Queue<Node> queue = new LinkedList<>(); // 큐
        queue.offer(v); // 큐에 시작 노드 삽입

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            Node now = queue.poll();    // 하나 꺼내어

            if(now.s.length() == 6) {   // 현재 노드의 문자열 길이가 6이면
                hashSet.add(now.s); // 해시셋에 저장

                continue;   // 다음 while()
            }

            // 문자열 길이가 6이 안되면
            int nowX = now.x, nowY = now.y; // 현재 좌표

            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY))   // 유효한지
                    continue;

                // 유효하면
                queue.offer(new Node(tmpX, tmpY, now.s + map[tmpX][tmpY])); // 큐에 삽입
            }
        }
    }

    public static void printNumCount() {    // 개수 출력

        for(int i = 0; i < 5; i++)  // 행
            for(int j = 0; j < 5; j++)  // 열
                BFS(new Node(i, j, map[i][j])); // 해당 좌표로 BFS

        System.out.println(hashSet.size()); // 해시셋 크기 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        printNumCount();    // 개수 출력
    }
}
