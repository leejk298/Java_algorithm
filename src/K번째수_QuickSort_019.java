import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class K번째수_QuickSort_019 {

    public static void quickSort(int[] A, int S, int E, int K) { // 퀵 정렬

        if (S < E) {
            int pivot = partition(A, S, E); // 분할

            if (pivot == K) // K번째 수 출력
                return;
            else if (pivot < K) // LT
                quickSort(A, pivot + 1, E, K);
            else // GT
                quickSort(A, S, pivot - 1, K);
        }
    }

    public static int partition(int[] A, int S, int E) { // 분할

        if (S + 1 == E) { // 두 개인 경우
            if (A[S] > A[E]) // 비교 후 스왑
                swap(A, S, E);

            return E; // pivot 값 리턴
        }

        // 세 개 이상인 경우
        int mid = (S + E) / 2; // 중앙값을 pivot으로
        swap(A, S, mid); // pivot을 숨기기 위해 맨 앞으로 이동

        int pivot = A[S];
        int i = S + 1, j = E; // i, j 인덱스 설정

        while (i <= j) { // 역전이 아니면 반복문 실행
            while (pivot < A[j] && j > 0) // j 이동
                j--;

            while (pivot > A[i] && i < A.length - 1) // i 이동
                i++;

            if (i <= j) // 역전이 아니면
                swap(A, i++, j--); // 스왑
        }

        A[S] = A[j]; // pivot을 맞는 위치로 이동
        A[j] = pivot;

        return j; // pivot 값 리턴
    }

    public static void swap(int[] A, int S, int E) { // 스왑

        int tmp = A[S];
        A[S] = A[E];
        A[E] = tmp;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken()); // 크기
        int K = Integer.parseInt(st.nextToken()); // K번째 수
        int A[] = new int[N]; // 배열

        st = new StringTokenizer(bf.readLine()); // 한 줄 스트링
        for (int i = 0; i < N; i++) // 배열 저장
            A[i] = Integer.parseInt(st.nextToken());

        quickSort(A, 0, N - 1, K - 1); // 퀵 정렬, 기대실행시간: O(NlogN), 최악실행시간: O(N^2)

        System.out.println(A[K - 1]); // K번째 수 출력
    }
}
