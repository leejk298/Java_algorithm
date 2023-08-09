import java.util.*;
import java.io.*;

/*
15
 */

public class 수들의합5_백준 {
    static int N;   // 크기
    static int[] arr;   // 입력배열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        N = Integer.parseInt(bf.readLine());    // 크기

        // 초기화
        arr = new int[N + 1];
        for(int i = 1; i <= N; i++)
            arr[i] = i; // 입력배열 저장
    }

    public static void findCount() {    // 개수 찾기

        int i = 1, j = 1, sum = 1, count = 0;   // 인덱스 설정, 합, 개수

        while(i <= j) { // 역전이 아니면 반복
            if(sum == N)    // 합이 크기와 같으면 개수 카운트
                count++;

            if(sum < N) {   // 작으면
                j++;    // 끝 인덱스 증가
                sum += j;   // 크기 키워줌
            } else {    // 크거나 같으면
                sum -= i;   // 크기 줄여줌
                i++;    // 시작 인덱스 증가
            }
        }

        System.out.println(count);  // 개수 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        findCount();    // 개수 찾기
    }
}
