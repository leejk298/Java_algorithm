import java.util.*;
import java.io.*;

/*
2
5 3
8 1 7 3 1
3 6 1
3 4
2 13 7
103 11 290 215
 */

public class 먹을것인가_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        int T = Integer.parseInt(bf.readLine());    // 테스트케이스 개수
        StringBuilder sb = new StringBuilder(); // 결과 문자열

        while (T-- > 0) {    // 개수만큼
            StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int N = Integer.parseInt(st.nextToken());   // 배열 크기
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];   // 배열 초기화
            int[] B = new int[M];

            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            for (int i = 0; i < N; i++)  // 크기만큼
                A[i] = Integer.parseInt(st.nextToken());    // 배열 저장

            st = new StringTokenizer(bf.readLine());

            for (int i = 0; i < M; i++)
                B[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(A); // 오름차순 정려
            Arrays.sort(B);

            int sum = 0;    // 총 개수

            for (int i = 0; i < M; i++) {    // B 크기
                int count = 0;  // 개수

                for (int j = 0; j < N; j++)    // A 크기
                    if (B[i] < A[j]) // 크면
                        count++;    // 개수 카운트

                sum += count;   // 총 개수 갱신

                if (count == 0)  // 해당 구간에서 개수가 없었으면
                    break;  // 다음도 없으므로 for - i문 종료
            }

            sb.append(sum + "\n");  // 총 개수 저장
        }

        System.out.print(sb);   // 결과 출력
    }
}
