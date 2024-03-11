import java.util.*;
import java.io.*;

/*
10
1 2 3 4 5 6 7 8 9 10
 */

public class 좋다_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken());   // 크기

        int[] arr = new int[N]; // 입력배열 초기화

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        for (int i = 0; i < N; i++) // 크기만큼
            arr[i] = Integer.parseInt(st.nextToken());  // 입력배열 저장

        Arrays.sort(arr);   // 오름차순 정렬

        int count = 0;  // 좋은 수의 개수
        for (int i = 0; i < N; i++) {   // 크기만큼
            int target = arr[i];    // 찾을 숫자

            int s = 0, e = N - 1;   // 인덱스
            while (s < e) { // 역전이 아니면, 같으면 안되므로 등호는 제외
                if (arr[s] + arr[e] == target) {    // 찾으면
                    if (s != i && e != i) { // 다른 수이면
                        count++;    // 개수 카운트

                        break;  // while 종료
                    } else if (s == i) {    // 하나라도 같으면
                        s++;    // 다음 숫자로
                    } else if (e == i) {
                        e--;
                    }
                } else if (arr[s] + arr[e] < target) {  // 찾는 숫자보다 작으면
                    s++;    // 시작 인덱스 갱신 => 더 커져야하므로
                } else  // 크면
                    e--;    // 끝 인덱스 갱신 => 더 작아져야하므로
            }
        }

        System.out.println(count);  // 개수 출력
    }
}
