import java.util.*;

/*
5
4 1 5 2 3
5
1 3 7 9 5
 */

public class 수찾기_백준 {
    static int N, M;    // 크기
    static int[] arr, find; // 입력배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        // 초기화
        N = sc.nextInt();
        arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        M = sc.nextInt();
        find = new int[M];
        for(int i = 0; i < M; i++)
            find[i] = sc.nextInt();
    }

    public static int binarySearch(int find) {  // 이진탐색

        int S = 0, E = N - 1;   // 인덱스

        while(S <= E) { // 역전이 아니면 반복
            int mid = (S + E) / 2;  // 중앙값

            if(arr[mid] == find)    // 같으면
                return 1;   // 리턴 1
            else if(arr[mid] > find)    // 크면
                E = mid - 1;    // Less Than
            else    // 작으면
                S = mid + 1;    // Greater Than
        }

        return 0;   // 없으면 0
    }

    public static void printIsExist() { // 존재 여부 출력

        Arrays.sort(arr);   // 이진탐색은 정렬 상태

        for(int i = 0; i < M; i++)  // 크기만큼
            System.out.println(binarySearch(find[i]));  // 이진탐색
    }

    public static void main(String[] args) {

        init(); // 초기화

        printIsExist(); // 존재 여부 출력
    }
}
