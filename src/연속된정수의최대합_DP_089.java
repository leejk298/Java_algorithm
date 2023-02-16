import java.util.*;
import java.io.*;

public class 연속된정수의최대합_DP_089 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼

        int N = Integer.parseInt(bf.readLine()); // 크기
        int A[] = new int[N]; // 배열

        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링
        for (int i = 0; i < N; i++) { // 크기만큼
            A[i] = Integer.parseInt(st.nextToken()); // 배열 저장
        }

        int L[] = new int[N]; // 왼쪽부터 연속된 정수의 최대합
        L[0] = A[0]; // 왼쪽부터 시작이므로 0번 인덱스 설정
        int res = L[0]; // 1개도 제거 안했을 때, 배열의 합 저장
        for (int i = 1; i < N; i++) { // 1 ~ N - 1
            L[i] = Math.max(A[i], L[i - 1] + A[i]); // 자기자신과 이전값들과의 합 비교 최대값
            res = Math.max(res, L[i]);	// 수열이 양수로만 구성되었을 수도 있기때문에
        }

        int R[] = new int[N]; // 오른쪽부터 연속된 정수의 최대합
        R[N - 1] = A[N - 1]; // 오른쪽부터 시작이므로 N-1번 인덱스 설정
        for (int i = N - 2; i > 0; i--) // N - 2 ~ 1
            R[i] = Math.max(A[i], R[i + 1] + A[i]); // 자기자신과 이전값들과의 합 비교 최대값

        for (int i = 1; i < N - 1; i++) { // 제거해야할 인덱스 찾아서 최대 합 구하기
            int tmp = L[i - 1] + R[i + 1]; // i를 기준으로 왼쪽 오른쪽의 연속된 정수 최대합
            res = Math.max(res, tmp); // 1개도 제거 안했을 때와 제거했을 때의 값 비교 최대값
        }

        System.out.println(res); // 최대값 출력
    }
}
