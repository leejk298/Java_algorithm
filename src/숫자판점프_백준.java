import java.util.*;

/*
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
1 1 1 2 1
1 1 1 1 1
 */

public class 숫자판점프_백준 {
    static String[][] map;  // 문자열 맵
    static HashSet<String> hashSet; // 해시셋, 중복제거
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    static class Node { // 내부클래스
        int x, y;   // 좌표
        String s;   // data

        public Node (int x, int y, String s) {  // 생성자
            this.x = x;
            this.y = y;
            this.s = s;
        }
    }

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        // 초기화
        map = new String[5][5];
        hashSet = new HashSet<>();

        for(int i = 0; i < 5; i++)
            map[i] = sc.nextLine().split(" ");  // 한 줄 스트링을 공백 기준으로 나눠 문자열로 저장
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= 5 || y < 0 || y >= 5);
    }

    public static void BFS(Node v) {    // BFS

        Queue<Node> queue = new LinkedList<>(); // 큐
        queue.offer(v); // 시작점 삽입

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            Node now = queue.poll();

            if(now.s.length() == 6) {   // 6자리수가 되면
                hashSet.add(now.s); // 해시셋에 저장, 중복 허용 X

                continue;   // 다음 반복문으로 -> while()
            }

            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = now.x + dx[i], tmpY = now.y + dy[i]; // 다음 좌표

                if(isNotValidPos(tmpX, tmpY))   // 유효한지
                    continue;

                queue.offer(new Node(tmpX, tmpY, now.s + map[tmpX][tmpY])); // 큐에 삽입, 문자열 합하여
            }
        }
    }

    public static void printNumCount() {    // 6자리수 개수

        for(int i = 0; i < 5; i++)  // 행
            for(int j = 0; j < 5; j++)  // 열
                BFS(new Node(i, j, map[i][j])); // 노드 객체로 BFS

        System.out.println(hashSet.size()); // 개수 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        printNumCount();    // 개수 출력
    }
}
