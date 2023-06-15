import java.io.*;

/*
8
11110000
11110000
00011100
00011100
11110000
11110000
11110011
11110011
 */

public class 쿼드트리_백준 {
    static int N;   // 크기
    static char[][] map;    // 입력배열
    static StringBuilder sb;    // 문자열 만들기

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        N = Integer.parseInt(bf.readLine());    // 크기
        sb = new StringBuilder();

        // 초기화
        map = new char[N][N];
        for(int i = 0; i < N; i++)  // 행
            map[i] = bf.readLine().toCharArray();   // 한 줄 스트링을 문자배열에 저장
    }

    public static boolean isSameColor(int x, int y, int size) { // 같은 색깔인지

        char color = map[x][y]; // 기준 색

        for(int i = x; i < x + size; i++)   // 행
            for(int j = y; j < y + size; j++)   // 열
                if(map[i][j] != color)  // 하나라도 다르면
                    return false;   // false

        return true;    // 전부 같으면 true
    }

    public static void DivideAndConquer(int x, int y, int size) {   // 분할 정복

        // 베이스케이스
        if(isSameColor(x, y, size)) {   // 같은 색깔이면
            sb.append(map[x][y]);   // 문자열에 추가

            return; // 함수 리턴
        }

        size /= 2;  // 사이즈 갱신
        sb.append("("); // 시작 괄호
        DivideAndConquer(x, y, size);   // 1
        DivideAndConquer(x, y + size, size);    // 2
        DivideAndConquer(x + size, y, size);    // 3
        DivideAndConquer(x + size, y + size, size); // 4
        sb.append(")"); // 종료 괄호
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        DivideAndConquer(0, 0, N);  // 분할 정복

        System.out.println(sb.toString());  // 결과 출력
    }
}
