import java.util.*;
import java.io.*;

/*
4 8
3 1 2 3 4 1 1 2
 */

public class 빗물_백준 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken());   // 세로
        int M = Integer.parseInt(st.nextToken());   // 가로

        int[] arr = new int[M]; // 입력배열 초기화

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        for(int i = 0; i < M; i++)  // 가로
            arr[i] = Integer.parseInt(st.nextToken());  // 입력배열 저장

        int res = 0;    // 결과값 초기화

        for(int i = 1; i < M - 1; i++) {    // 가장자리 제외한 구간에 대해
            int left = 0, right = 0;    // 각 구간의 왼, 오른쪽 값 초기화

            for(int j = 0; j < i; j++)  // 왼쪽
                left = Math.max(left, arr[j]);  // 최대값

            for(int j = i + 1; j < M; j++)  // 오른쪽
                right = Math.max(right, arr[j]);    // 최대값

            if(arr[i] < left && arr[i] < right) // 해당 값이 왼, 오른쪽 값보다 작으면
                res += Math.min(left, right) - arr[i];  //  빗물의 양 갱신
        }

        System.out.println(res);    // 결과값 출력
    }
}
