import java.util.*;
import java.io.*;

/*
4
12345
3333
97531
102030
 */


public class 코테복기4_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken());   // 크기

        int count = 0;  // 개수
        for(int i = 0; i < N; i++) {    // 크기만큼
            String str = bf.readLine(); // 한 줄 스트링

            int size = str.length();    // 문자열 길이
            int t = size / 3;   // 몇 자리까지 가능한 지, 0 ~ 99 이므로 최대 3자리가 바뀔 수 있다고 생각
            for(int j = 1; j <= t; j++) { // 가능한 자리수 개수만큼
                boolean flag = true;    // 초기 true
                int arrSize = size / j; // 자리수 나눈 배열
                int[] arr = new int[arrSize];

                for(int k = 0; k <= size - j; k += j)   // 크기만큼만 나오게 size - j 까지
                   arr[k / j] = Integer.parseInt(str.substring(k, k + j));  // 배열 저장

                int dif = arr[1] - arr[0];  // 차이
                if(dif < 0 || dif >= 100) // 0 이만, 100 이상이면 건너뛰기
                    continue;   // 건너뛰기

                for(int k = 1; k < arr.length - 1; k++) {   // 나머지
                    if(dif != (arr[k + 1] - arr[k])) {  // 다르면
                        flag = false;   // false

                        break;  // 비교 그만
                    }
                }

                if(flag) {  // true 면
                    count++;    // 개수 카운트

                    break;  // 반복문 종료 -> 자리수 하나만 가능 -> 다음 숫자로 넘어감
                }
            }
        }

        System.out.println(count);  // 개수 출력
    }
}
