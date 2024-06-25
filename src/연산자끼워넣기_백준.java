import java.util.*;

public class 연산자끼워넣기_백준 {
    static int max; // 최대값
    static int min; // 최소값
    static int[] number;  // 피연산자
    static int[] operator; // 연산자
    static int N;  // 크기

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기

        number = new int[N];    // 피연산자
        max = Integer.MIN_VALUE;    // 최대값
        min = Integer.MAX_VALUE;    // 최소값
        operator = new int[4];  // 연산자

        for (int i = 0; i < N; i++) // 크기만큼
            number[i] = sc.nextInt();   // 피연산자 저장

        for (int i = 0; i < 4; i++)
            operator[i] = sc.nextInt(); // 연산자 4개, + - * /
    }

    public static void BackTracking(int num, int idx) { // 백트래킹

        if (idx == N) { // 베이스케이스
            max = Math.max(max, num);   // 최대값 저장
            min = Math.min(min, num);   // 최소값 저장

            return; // 함수 리턴
        }

        for (int i = 0; i < 4; i++) {   // 4개

            if (operator[i] > 0) {  // 연산자가 있으면
                operator[i]--;  // 개수 하나 줄이고

                switch (i) {    // switch()
                    case 0: // 0이면 +
                        BackTracking(num + number[idx], idx + 1);
                        break;  // 리턴되면 switch() 종료
                    case 1: // 1이면 -
                        BackTracking(num - number[idx], idx + 1);
                        break;
                    case 2: // 2이면 *
                        BackTracking(num * number[idx], idx + 1);
                        break;
                    case 3: // 3이면 /
                        BackTracking(num / number[idx], idx + 1);
                        break;
                }

                operator[i]++;  // 리턴되면 다시 해당 연산자 개수 갱신
            }
        }
    }

    public static void main(String[] args) {

        init(); // 초기화

        BackTracking(number[0], 1); // DFS, 백트래킹

        System.out.println(max);    // 최대값
        System.out.println(min);    // 최소값 출력
    }
}
