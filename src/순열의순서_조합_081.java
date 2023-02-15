import java.util.*;
import java.io.*;

public class 순열의순서_조합_081 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼

        int N = Integer.parseInt(bf.readLine()); // 개수

        long F[] = new long[N + 1]; // 팩토리얼
        int S[] = new int[N + 1]; // 수열
        boolean visited[] = new boolean[N + 1]; // 숫자 사용여부

        F[0] = 1; // 0! = 1
        for (int i = 1; i <= N; i++) // 개수만큼
            F[i] = F[i - 1] * i; // 팩토리얼 설정

        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        int M = Integer.parseInt(st.nextToken()); // 소문제
        if (M == 1) { // 1번이면
            long K = Integer.parseInt(st.nextToken()); // 몇 번째 수열

            for (int i = 1; i <= N; i++) { // 몇 번째 자리에
                for (int j = 1, flag = 1; j <= N; j++) { // 몇 번째 숫자가 들어갈 지
                    if (visited[j]) // 해당 숫자가 이미 사용되었으면 패스
                        continue;
                    if (K <= flag * F[N - i]) { // 몇 번째 숫자인 지 맞을 때까지 flag 설정(= 몇 번째 숫자)
                        // 첫 번째 자리면 K값 갱신 필요 X => 맞는 자리이므로 => flag - 1
                        K = K - (F[N - i] * (flag - 1)); // N - i : (해당 자리 - 1)에서 경우의 수 계산
                        S[i] = j; // 해당 숫자를 맞는 자리에 저장
                        visited[j] = true; // 해당 숫자 사용여부 갱신

                        break; // for(j)문 탈출 => 다음 자리 수로 for(i)
                    }

                    flag++; // flag 갱신
                }
            }

            for (int i = 1; i <= N; i++) // 수열 출력
                System.out.print(S[i] + " ");
        }

        if (M == 2) { // 2번이면
            long K = 1; // K 번째 수열 초기화

            for (int i = 1; i <= N; i++) { // 몇 번째 자리에
                S[i] = Integer.parseInt(st.nextToken()); // 수열 입력받기

                int cnt = 1; // 몇 번째인 지 카운트하기 위해
                for (int j = 1; j < S[i]; j++) // 무슨 숫자가 들어갈 지
                    if (!visited[j]) // 해당 숫자가 사용되지 안았으면
                        cnt++; // 몇 번째인지 카운트 갱신

                // N - i : (해당 자리 - 1)에서 경우의 수 계산, 맞는 자리에 들어가면 cnt가 1이므로 cnt - 1
                K = K + F[N - i] * (cnt - 1); // 몇 번째인 지(= K) 갱신
                visited[S[i]] = true; // 맞는 자리에 들어간 해당 숫자 사용여부 갱신
            }

            System.out.println(K); // 출력
        }
    }
}
