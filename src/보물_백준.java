import java.nio.Buffer;
import java.util.*;
import java.io.*;

/*
5
1 1 1 6 0
2 7 8 3 1
 */

public class 보물_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken());   // 크기

        // 초기화
        int[] A = new int[N];
        int[] B = new int[N];

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링
        for(int i = 0; i < N; i++)  // 크기만큼
            A[i] = Integer.parseInt(st.nextToken());    // A배열

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++)
            B[i] = Integer.parseInt(st.nextToken());    // B배열

        Arrays.sort(A); // 오름차순 정렬
        Arrays.sort(B);

        long sum = 0;   // 총 합
        for(int i = 0; i < N; i++)  // 크기만큼
            sum += A[i] * B[N - 1 - i]; // 최소값 구하기

        System.out.println(sum);    // 결과값 출력
    }
}
