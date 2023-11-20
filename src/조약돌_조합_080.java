import java.util.*;
import java.io.*;

public class 조약돌_조합_080 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼

        int M = Integer.parseInt(bf.readLine()); // 색상 개수
        int D[] = new int[M]; // 조약돌개수 배열, 크기: M
        double P[] = new double[M]; // 각 색상마다 같은색 K개 뽑을 확률
        double res = 0.0; // 결과
        int cnt = 0; // 조약돌 총 개수

        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        for (int i = 0; i < M; i++) { // 색상 개수만큼
            D[i] = Integer.parseInt(st.nextToken()); // 조약돌 개수 입력받기
            cnt += D[i]; // 총 개수 갱신
        }

        int K = Integer.parseInt(bf.readLine()); // 같은 색깔의 조약돌 몇 개 뽑을건지

        for (int i = 0; i < M; i++) { // 색상 개수만큼
            if (D[i] >= K) { // 뽑을 개수가 해당 색깔의 조약돌 개수보다 작거나 같으면
                P[i] = 1.0; // 해당 조약돌의 확률 1로 초기화
                for (int j = 0; j < K; j++) { // 뽑을 개수만큼
                    P[i] = P[i] * (double) (D[i] - j) / (cnt - j); // 각 조약돌의 확률 계산
                }
            }

            res += P[i]; // 총 확률
        }

        System.out.println(res); // 출력
    }
}
