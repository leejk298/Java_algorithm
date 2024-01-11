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

        int H = Integer.parseInt(st.nextToken());   // 높이
        int W = Integer.parseInt(st.nextToken());   // 너비

        int[] arr = new int[W]; // 입력배열

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링
        for(int i = 0; i < W; i++)  // 너비만큼
            arr[i] = Integer.parseInt(st.nextToken());  // 입력배열 저장

        int sum = 0;    // 빗물
        for(int i = 1; i < W - 1; i++) {    // 처음과 마지막은 빗물이 찰 수 없음
            int l = 0, r = 0;   // 왼, 오른쪽 인덱스

            for(int j = 0; j < i; j++)  // 왼쪽
                l = Math.max(l, arr[j]);    // 최대값

            for(int j = i + 1; j < W; j++)  // 오른쪽
                r = Math.max(r, arr[j]);    // 최대값

            if(arr[i] < l && arr[i] < r)    // 잠기면
                sum += Math.min(l, r) - arr[i]; // 잠기는 양 = 최소값 - 해당값
        }

        System.out.println(sum);    // 총량 출력
    }
}
