import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 오일러피함수_정수론_041 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼

        long N = Long.parseLong(bf.readLine()); // 숫자
        long res = N; // 결과

        for (long p = 2; p <= Math.sqrt(N); p++) { // 제곱근까지만 수행
            if (N % p == 0) { // p가 소인수인지 확인
                res = res - (res / p); // 결과값 업데이트

                while (N % p == 0) // 2^7 * 11 이면 2^7 제거하고 11만 남김
                    N /= p;
            }
        }

        if (N > 1) // 아직 소인수 구성이 남아있으면 => N이 마지막 소인수일 때
            res = res - (res / N); // 반복문에서 제곱근까지만 탐색했으므로 1개의 소인수가 누락되는 케이스

        System.out.println(res); // 출력
    }
}
