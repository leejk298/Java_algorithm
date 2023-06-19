import java.util.*;

/*
5
6 3 2 10 -10
8
10 9 -5 2 3 4 5 -10
 */

public class 숫자카드_백준 {
    static int N, M;    // 크기
    static int[] arr;   // 입력배열

    public static boolean BinarySearch(int t) { // 이분 탐색

        int S = 0, E = N - 1;   // 인덱스

        while (S <= E) { // 역전이 아니면 반복
            int mid = (S + E) / 2;  // 중앙값

            if (t < arr[mid])    // 크면
                E = mid - 1;    // 큰 쪽 인덱스 줄이고
            else if (t > arr[mid])   // 작으면
                S = mid + 1;    // 작은 쪽 인덱스 키우고
            else    // 같으면
                return true;    // true
        }

        return false;   // 역전이 되면 없는 것이므로 false
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();  // 크기

        // 초기화
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);   // 오름차순 정렬

        // 초기화
        M = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {   // 크기만큼
            int t = sc.nextInt();   // 구해야할 숫자

            if (BinarySearch(t))    // 이분 탐색, 존재하면
                sb.append("1 ");    // 1
            else    // 아니면
                sb.append("0 ");    // 0
        }

        System.out.println(sb.toString());  // 결과 출력
    }
}
