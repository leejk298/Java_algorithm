import java.io.*;
import java.util.Scanner;

public class 수_정렬_MergeSort_020 {
    static int A[], tmp[];

    public static void mergeSort(int S, int E) { // 합병정렬

        if (E - S < 1) // 베이스케이스: 1개가 될 때까지 분할
            return;

        // 2개 이상이면
        int mid = (E + S) / 2; // 중앙값

        mergeSort(S, mid); // LT
        mergeSort(mid + 1, E); // GT

        for (int i = S; i <= E; i++) { // 복사
            tmp[i] = A[i];
        }

        int K = S; // 총 배열 인덱스 관리
        int i = S, j = mid + 1; // 부분집합 배열 인덱스 관리

        while (i <= mid && j <= E) { // 부분집합 두 개 비교하여 정렬
            if (tmp[i] > tmp[j]) {
                A[K] = tmp[j];
                K++;
                j++;
            } else {
                A[K] = tmp[i];
                K++;
                i++;
            }
        }

        while (i <= mid) { // LT, 나머지 복사
            A[K] = tmp[i];
            K++;
            i++;
        }

        while (j <= E) { // GT, 나머지 복사
            A[K] = tmp[j];
            K++;
            j++;
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in); // 입력

        int N = sc.nextInt(); // 크기
        A = new int[N]; // 원본배열
        tmp = new int[N]; // 복사배열

        for (int i = 0; i < N; i++) { // 배열 저장
            A[i] = sc.nextInt();
        }

        mergeSort(0, N - 1); // 합병정렬, 실행시간: O(NlogN)

        for (int i = 0; i < N; i++) { // 출력
            System.out.println(A[i]);
        }
    }
}
