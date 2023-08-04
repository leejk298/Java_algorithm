import java.util.*;
import java.io.*;

/*
4
2
1
2
12
1
 */

public class 카드놓기_백준 {
    static int N, K;    // 크기
    static String[] A;  // 입력배열
    static Set<String> hashSet; // 해시셋
    static boolean[] visited;   // 방문배열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        N = Integer.parseInt(bf.readLine());    // 크기
        K = Integer.parseInt(bf.readLine());    // 개수

        // 초기화
        A = new String[N];
        visited = new boolean[N];
        hashSet = new HashSet<>();

        for(int i = 0; i < N; i++)  // 크기만큼
            A[i] = bf.readLine();   // 입력배열 저장
    }

    public static void DFS(int depth, String str) { // DFS, 브루트포스

        if(depth == K) {    // K와 같으면
            hashSet.add(str);   // 해시셋에 추가

            return; // 함수 리턴: 완전 탐색하기 위해
        }

        // K와 다르면
        for(int i = 0; i < N; i++) {    // 크기만큼
            if(!visited[i]) {   // 방문한 적이 없으면 -> 중복제거
                visited[i] = true;  // 방문
                DFS(depth + 1, str + A[i]); // DFS, 재귀콜
                visited[i] = false; // 리턴되면 해당 인덱스 방문 여부 갱신
            }
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        DFS(0, ""); // DFS, 브루트포스

        System.out.println(hashSet.size()); // 해시셋 크기 출력
    }
}
