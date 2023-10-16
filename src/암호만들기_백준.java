import java.io.*;
import java.util.*;

/*
4 6
a t c i s w
 */

public class 암호만들기_백준 {
    static int N, M;    // 크기
    static char[] ch, res;  // 입력, 결과배열
    static boolean[] visited;   // 방문배열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 크기
        M = Integer.parseInt(st.nextToken());

        // 초기화
        ch = new char[M];
        res = new char[N];
        visited = new boolean[M];

        String[] str = bf.readLine().split(" ");    // 공백 기준으로 문자열 배열에 저장
        for(int i = 0; i < M; i++)  // 크기만큼
            ch[i] = str[i].charAt(0);   // 문자로 변환 후 저장

        Arrays.sort(ch);    // 알파벳 순으로 정렬
    }

    public static boolean isValidPassword(char[] res) { // 암호가 가능한지

        int mo = 0, ja = 0; // 모음, 자음 개수

        for(char c : res) { // 문자 배열 순회
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')    // 모음이면
                mo++;   // 개수 카운트
            else    // 자음이면
                ja++;
        }

        if(mo >= 1 && ja >= 2)  // 조건에 맞으면
            return true;    // true

        return false;   // 아니면 false
    }

    public static void DFS(int depth, int index) {  // DFS, 백트래킹: 브루트포스에서 조건을 추가해 의미없는 반복 x
        // 베이스케이스
        if(depth == N) {    // N개가 되면
            if(isValidPassword(res))    // 문자배열이 암호가 가능한지
                System.out.println(res);    // 가능하면 출력

            return; // 함수 리턴: 완전 탐색
        }

        // 재귀케이스: N개가 아니면
        for(int i = index; i < M; i++) {    // 해당하는 index 부터 M 까지
            if(!visited[i]) {   // 방문한 적이 없으면
                visited[i] = true;  // 방문
                res[depth] = ch[i]; // 결과 문자열에 저장
                DFS(depth + 1, i + 1);  // DFS
                visited[i] = false; // 함수 리턴되면 해당 index 방문 여부 갱신
            }
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        DFS(0, 0);  // DFS: 길이 0, 인덱스 0부터 시작
    }
}
