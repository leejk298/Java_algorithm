import java.util.*;

/*
4 8
3 1 2 3 4 1 1 2
 */

public class 빗물_백준 {
    static int H, W;    // 크기
    static int[] arr;   // 배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        H = sc.nextInt();   // 높이
        W = sc.nextInt();   // 너비

        // 초기화
        arr = new int[W];
        for(int i = 0; i < W; i++)
            arr[i] = sc.nextInt();
    }

    public static void printAmountRain() {  // 빗물의 양 출력

        int amount = 0; // 양

        for(int i = 1; i < W - 1; i++) {    // 처음과 마지막은 빗물이 찰 수 없으므로 제외
            int left = 0, right = 0;    // 왼, 오른쪽 가장 큰 수 찾기

            for(int j = 0; j < i; j++)  // 왼쪽
                left = Math.max(left, arr[j]);  // 가장 큰 수

            for(int j = i + 1; j < W; j++)  // 오른쪽
                right = Math.max(right, arr[j]);    // 가장 큰 수

            if(arr[i] < left && arr[i] < right) // 양 쪽다 현재 높이보다 크면
                amount += Math.min(left, right) - arr[i];   // 둘 중 작은 값에서 차이만큼 더함
        }

        System.out.println(amount); // 총 빗물의 양 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        printAmountRain();  // 빗물의 양 출력
    }
}
