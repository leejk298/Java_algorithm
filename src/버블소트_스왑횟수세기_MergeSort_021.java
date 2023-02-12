import java.io.*;
import java.util.*;

public class 버블소트_스왑횟수세기_MergeSort_021 {
    public static long res;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 버퍼

        int N = Integer.parseInt(bf.readLine()); // 크기
        int A[] = new int[N]; // 배열
        int tmp[] = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        for (int i = 0; i < N; i++) // 크기만큼
            A[i] = Integer.parseInt(st.nextToken()); // 배열 저장

        res = 0; // 스왑횟수

        MergeSort(A, tmp, 0, N - 1); // 함수 호출

        System.out.println(res); // 출력
    }

    private static void MergeSort(int[] A, int[] tmp, int S, int E) {
        if (E - S < 1) // 1개 될 때까지 쪼갬
            return;

        int m = (S + E) / 2; // 중간값

        MergeSort(A, tmp, S, m); // LT

        MergeSort(A, tmp, m + 1, E); // GT

        for (int i = S; i <= E; i++) // 임시 배열에 저장
            tmp[i] = A[i];

        int k = S; // 총 배열 idx
        int idx1 = S; // LT idx
        int idx2 = m + 1; // GT idx

        while (idx1 <= m && idx2 <= E) { // LT GT 크기비교하여
            if (tmp[idx1] > tmp[idx2]) { // 앞이 크면
                A[k] = tmp[idx2]; // 스왑
                res = res + idx2 - k; // GT에 해당하는 idx2 - k => 이동거리: 스왑횟수
                k++;
                idx2++;
            }

            else {
                A[k] = tmp[idx1];
                k++;
                idx1++;
            }
        }

        while (idx1 <= m) { // LT 나머지 복사
            A[k] = tmp[idx1];
            k++;
            idx1++;
        }

        while (idx2 <= E) { // GT 나머지 복사
            A[k] = tmp[idx2];
            k++;
            idx2++;
        }
    }
}
