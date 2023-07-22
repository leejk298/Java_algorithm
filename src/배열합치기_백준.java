import java.util.*;
import java.io.*;

/*
4 3
2 3 5 9
1 4 7
 */

public class 배열합치기_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken());   // 배열 A 크기
        int M = Integer.parseInt(st.nextToken());   // 배열 B 크기

        // 초기화
        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링
        for(int i = 0; i < N; i++)  // 크기만큼
            A[i] = Integer.parseInt(st.nextToken());    // 배열 A 저장

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링
        for(int i = 0; i < M; i++)  // 크기만큼
            B[i] = Integer.parseInt(st.nextToken());    // 배열 B 저장

        StringBuilder sb = new StringBuilder(); // 결과 문자열

        int i = 0, j = 0;   // 인덱스
        while(i < N && j < M) { // 둘 다 유효하면
            if(A[i] < B[j]) // 크기 비교
                sb.append(A[i++] + " ");
            else
                sb.append(B[j++] + " ");
        }

        // 나머지 배열 채우기
        while(i < N)    // A가 남아있으면
            sb.append(A[i++] + " ");    // 나머지

        while(j < M)    // B가 남아있으면
            sb.append(B[j++] + " ");    // 나머지

        System.out.println(sb); // 결과 출력
    }
}
