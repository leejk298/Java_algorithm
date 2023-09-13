import java.util.*;
import java.io.*;

public class 가장길게증가하는수열_DP_096 {
    static int N, maxLength; // 개수, 최대길이
    static int B[]; // 맞는 위치
    static int A[]; // 수열
    static int D[]; // 길이
    static int res[]; // 결과

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼

        N = Integer.parseInt(bf.readLine()); // 개수
        A = new int[N + 1]; // 초기화, 크기: N 포함 => N + 1
        B = new int[N + 1];
        D = new int[N + 1];
        res = new int[N + 1];

        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        for (int i = 1; i <= N; i++) // 개수만큼
            A[i] = Integer.parseInt(st.nextToken()); // 수열 저장

        int index; // 위치
        B[++maxLength] = A[1]; // 한 개 받고
        D[1] = 1; // 길이 1 저장

        for (int i = 2; i <= N; i++) { // 2부터 N까지
            if (B[maxLength] < A[i]) { // 다음 수열의 크기가 크면
                B[++maxLength] = A[i]; // 맞는 위치 배열에 저장
                D[i] = maxLength; // (맞는 위치의 인덱스 == 해당 수열 길이) 카운트하여 저장
            } else { // 작으면
                index = binarySearch(1, maxLength, A[i]); // 맞는 위치로, 이진탐색
                B[index] = A[i]; // 저장
                D[i] = index; // 해당 수열 숫자의 길이 저장
            }
        }

        System.out.println(maxLength); // 최대증가 길이 출력

        index = maxLength; // 인덱스 설정
        int x = B[maxLength] + 1; // 최대값 설정

        for (int i = N; i >= 1; i--) { // 뒤에서 부터
            if (D[i] == index && A[i] < x) { // 맞는 위치이고 최대값보다 작으면
                res[index] = A[i]; // 해당 값을 결과배열에 저장
                x = A[i]; // 다음 최대값 설정
                index--; // 인덱스 갱신
            }
        }

        for (int i = 1; i <= maxLength; i++) // 결과 출력
            System.out.print(res[i] + " ");
        System.out.println();
    }

    private static int binarySearch(int l, int r, int now) { // 이진 탐색

        int mid; // 중간값

        while (l < r) { // 역전이 일어나지않을 때까지 반복
            mid = (l + r) / 2;

            if (B[mid] < now) // 중간값보다 크면
                l = mid + 1; // left 갱신 => GT
            else // 중간값보다 작으면
                r = mid; // right 갱신 => LT
        }

        return l; // 역전이 일어났으므로 맞는 위치(left) 리턴
    }
}
