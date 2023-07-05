import java.io.*;
import java.util.*;

/*
4 6
a t c i s w
 */

public class 암호만들기_백준 {
    static int N, M;    // 크기
    static char[] ch, res;  // 입력, 결과배열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 결과배열 크기
        M = Integer.parseInt(st.nextToken());   // 입력배열 크기

        // 초기화
        ch = new char[M];
        res = new char[N];

        String[] str = bf.readLine().split(" ");    // 공백 기준으로 문자열 나눔
        for(int i = 0; i < M; i++)  // 크기만큼
            ch[i] = str[i].charAt(0);   // 문자로 형변환하여 저장

        Arrays.sort(ch);    // 사전순 -> 오름차순 정렬
    }

    public static boolean isValidPassword(char[] res) { // 암호가 가능한지

        int mo = 0, ja = 0; // 모음, 자음 개수

        for(char c : res) { // 결과배열 순회
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')    // 모음
                mo++;
            else    // 자음
                ja++;
        }

        if(mo >= 1 && ja >= 2)  // 모음 1개 이상 자음 2개 이상이면
            return true;    // true 리턴

        return false;   // 아니면 false 리턴
    }

    public static void DFS(int depth, int index) {  // DFS, 브루트포스

        if(depth == N) {    // 길이 도달하면
            if(isValidPassword(res))    // 암호가 가능하면
                System.out.println(res);    // 출력

            return; // 완전 탐색위해 함수 리턴
        }

        // 도달하지 않으면
        for(int i = index; i < M; i++) {    // 입력 크기만큼
            res[depth] = ch[i]; // 결과배열 저장
            DFS(depth + 1, i + 1);  // 재귀콜: 문자열길이 + 1, 중복되지않게 인덱스 + 1
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        DFS(0, 0);  // DFS: 길이 0, 인덱스 0부터 시작
    }
}
