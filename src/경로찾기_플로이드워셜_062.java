import java.io.*;
import java.util.*;

public class 경로찾기_플로이드워셜_062 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼

        int N = Integer.parseInt(bf.readLine()); // 노드

        int A[][] = new int[N + 1][N + 1]; // 인접행렬

        for (int i = 1; i <= N; i++) { // 노드 개수만큼
            StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

            for (int j = 1; j <= N; j++) { // 2차 배열
                A[i][j] = Integer.parseInt(st.nextToken()); // 인접행렬 구현
            }
        }

        // 플로이드워셜 알고리즘 로직
        for (int k = 1; k <= N; k++) // 경유지 K에 대해
            for (int i = 1; i <= N; i++) // 출발노드 S
                for (int j = 1; j <= N; j++) // 도착노드 E
                    if (A[i][k] == 1 && A[k][j] == 1) // 경유지 K를 거치는 길이 있으면
                        A[i][j] = 1; // 출발 -> 도착으로 가는 길이 있다 (가중치 X)

        for (int i = 1; i <= N; i++) { // 인접행렬 출력
            for (int j = 1; j <= N; j++) {
                System.out.print(A[i][j] + " ");
            }

            System.out.println(); // 개행문자
        }
    }
}
