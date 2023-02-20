import java.util.*;
import java.io.*;

public class 최소공통부분문자열_DP_090 {
    static long DP[][]; // 점화식배열
    static char A[]; // 문자열 1
    static char B[]; // 문자열 2
    static ArrayList<Character> P; // LCS 저장리스트

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼

        A = bf.readLine().toCharArray(); // 문자 배열로 저장
        B = bf.readLine().toCharArray();
        DP = new long[A.length + 1][B.length + 1]; // 점화식 배열 초기화, 크기: N + 1 => 0번 index 버림
        P = new ArrayList<Character>(); // 리스트 초기화

        for (int i = 1; i <= A.length; i++) { // 문자열 A 길이 만큼
            for (int j = 1; j <= B.length; j++) { // B 길이 만큼
                if (A[i - 1] == B[j - 1]) { // 같으면
                    DP[i][j] = DP[i - 1][j - 1] + 1; // 대각선 위 (이전 LCS 길이값) + 1
                } else { // 다르면 각 문자열에서 이전 값 중 큰 값으로 설정
                    DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]); // 왼쪽이나 위쪽 중 큰 값으로 설정
                }
            }
        }

        System.out.println(DP[A.length][B.length]); // LCS 길이 출력

        getText(A.length, B.length); // LCS 문자열 구하기
        for (int i = P.size() - 1; i >= 0; i--) // 리스트 크기만큼, 역행 => 뒤에서부터 탐색하여 추가하였으므로
            System.out.print(P.get(i)); // 불러와서 출력
        System.out.println(); // 개행문자 출력
    }

    private static void getText(int r, int c) { // 문자열 구하기
        if (r == 0 || c == 0) // 베이스케이스: 둘 중 하나의 길이가 0이 되면 종료
            return;

        // 재귀케이스
        if (A[r - 1] == B[c - 1]) { // 같은 문자이면
            P.add(A[r - 1]); // 리스트에 저장
            getText(r - 1, c - 1); // 문자열 둘 다 다음 문자로 => 대각선 이동
        } else { // 다른 문자이면
            if (DP[r - 1][c] > DP[r][c - 1]) // 왼쪽이 크면 => 문자열 A의 LCS 길이값이 크면
                getText(r - 1, c); // 왼쪽으로 이동
            else // 위쪽이 크면 => 문자열 B의 LCS 길이값이 크면
                getText(r, c - 1); // 위쪽으로 이동
        }
    }
}