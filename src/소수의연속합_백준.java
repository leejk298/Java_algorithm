import java.util.*;

/*
20
 */

public class 소수의연속합_백준 {
    static int N;   // 숫자
    static List<Integer> primeList; // 소수 리스트

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 숫자
    }

    public static void getPrime() { // 소수 구하기

        // 초기화
        int[] num = new int[N + 1];
        for(int i = 2; i <= N; i++)
            num[i] = i;

        for (int i = 2; i <= Math.sqrt(N); i++) { // N의 제곱근까지
            // => N보다 작은수는 N의 제곱근보다 작은 약수를 갖게되므로 N의 제곱근까지만 탐색
            if (num[i] == 0) // 소수가 아니면 통과 => 성능이 나쁘지않음
                continue;

            // 소수면
            for (int j = i + i; j <= N; j = j + i) // 소수의 배수는 전부
                num[j] = 0; // 소수가 아닌 수로 고침
        }

        primeList = new ArrayList<>();  // 초기화

        for (int i = 2; i <= N; i++) // M 부터 N 까지
            if (num[i] != 0) // 소수가 아닌 수
                primeList.add(num[i]);  // 소수 리스트 저장
    }

    public static void printPrefixPrime() { // 연속된 소수들의 구간합

        int l = 0, r = 0;   // 투포인터
        int sum = 2, count = 0; // 합은 2부터, 개수
        int size = primeList.size();    // 소수 리스트 크기

        while(l < size && r < size) {   // 둘 다 유효한 인덱스이면 반복
            if(sum > N) {   // 합이 크면
                sum -= primeList.get(l);    // 합 갱신
                l++;    // left 이동
            } else if(sum < N) {    // 작으면
                r++;    // right 이동
                if(r == size)   // 인덱스 벗어나면
                    break;  // while 종료
                // 유효하면
                sum += primeList.get(r); // 합 갱신
            } else {    // 같으면
                count++;    // 개수 카운트
                sum -= primeList.get(l);    // 합 갱신
                l++;    // left 이동
            }
        }

        System.out.println(count);  // 개수 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        getPrime(); // 소수 구하기

        printPrefixPrime(); // 연속된 소수들의 구간합 개수 출력
    }
}
