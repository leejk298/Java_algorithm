import java.util.*;

/*
2 162
4 42
100 40021
 */

public class 최소연산_백준 {
    static long A, B, count;    // A -> B, 걸리는 최소연산수

    public static void init() { // 초기화
        Scanner sc = new Scanner(System.in);    // 입력

        A = sc.nextLong();  // A
        B = sc.nextLong();  // B
        count = -1;         // 초기화
    }

    public static void DFS(long A, int cnt) {   // DFS
        if(A > B)   // 크면 함수 종료
            return;

        if(A == B) {    // 같으면
            count = cnt;    // 최소연산수 저장
            return;     // 종료
        }

        DFS(A * 2, cnt + 1);    // 2배
        DFS(A * 10 + 1, cnt + 1);   // 오른쪽에 1 붙이기
    }

    public static void main(String[] args) {

        init(); // 초기화

        DFS(A, 1);  // DFS

        System.out.println(count);  // 최소연산수 출력
    }
}
