import java.util.*;

public class ATM_백준 {
    static int N;   // 크기
    static int[] arr;   // 입력배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기

        // 초기화
        arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
    }

    public static void printMinSum() {  // 최소 시간의 합 출력

        Arrays.sort(arr);   // 오름차순 정렬
        int res = 0, sum = 0;   // 결과, 합
        for(int i = 0; i < N; i++) {    // 크기만큼
            sum += arr[i];  // 합
            res += sum; // 결과값
        }

        System.out.println(res);    // 결과값 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        printMinSum();  // 최소 시간의 합 출력
    }
}
