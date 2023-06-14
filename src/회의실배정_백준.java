import java.util.*;

/*
11
1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14
 */

public class 회의실배정_백준 {
    static int N;   // 크기
    static int[][] arr; // 입력배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기

        // 초기화
        arr = new int[N][2];
        for(int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
    }

    public static void printMaxCount() {    // 회의 최대 개수 출력

        // 정렬
        Arrays.sort(arr, (o1, o2) -> {
            if(o1[1] == o2[1])  // 종료시간이 같으면
                return o1[0] - o2[0];   // 시작시간 빠른순
            // 종료시간이 다르면 종료시간 빠른 순
            return o1[1] - o2[1];
        });

        int count = 0, t = 0;   // 개수, 시간
        for(int i = 0; i < N; i++) {    // 크기만큼
            if(t <= arr[i][0]) {    // 직전 종료시간이 다음 회의 시간보다 작거나 같으면
                t = arr[i][1];  // 갱신
                count++;    // 개수 카운트
            }
        }

        System.out.println(count);  // 개수 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        printMaxCount();    // 회의 최대 개수 출력
    }
}
