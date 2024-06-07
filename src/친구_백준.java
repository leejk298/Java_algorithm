import java.util.*;
import java.io.*;

/*
3
NYY
YNY
YYN
 */

public class 친구_백준 {
    static int N;   // 크기
    static char[][] map;    // 입력배열
    static boolean[] visited;   // 방문배열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        N = Integer.parseInt(bf.readLine());    // 크기

        map = new char[N][N];   // 입력배열

        for (int i = 0; i < N; i++) // 행
            map[i] = bf.readLine().toCharArray();   // 입력배열 저장
    }

    public static void printMaxCount() {    // 최대값 출력

        int answer = 0; // 결과값

        for (int i = 0; i < N; i++) {   // 행
            visited = new boolean[N];   // 방문배열
            Queue<Integer> queue = new LinkedList<>();  // 큐

            visited[i] = true;  // 시작점부터 방문
            queue.offer(i); // 큐에 삽입

            int depth = 0, count = 0;   // 2-친구, 개수

            while (depth < 2) { // 한 친구 건너서 알게되는 사람까지
                int size = queue.size();    // 크기

                for (int j = 0; j < size; j++) {    // 크기만큼
                    int now = queue.poll(); // 하나 꺼내어

                    for (int k = 0; k < N; k++) {   // 개수만큼
                        if (map[now][k] == 'Y' && !visited[k]) {    // 친구가 가능
                            visited[k] = true;  // 방문
                            count++;    // 개수 카운트
                            queue.offer(k); // 큐에 삽입
                        }
                    }
                }

                depth++;    // 깊이 카운트
            }

            answer = Math.max(answer, count);   // 최대값 갱신
        }

        System.out.println(answer); // 결과값 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        printMaxCount();    // 최대값 출력
    }
}
