import java.util.*;
import java.io.*;

/*
1
5
4 1 5 2 3
5
1 3 7 9 5
 */

public class 암기왕_백준 {

    static StringBuilder sb;    // 결과 문자열

    public static void BinarySearch(int[] arr, int t, int S, int E) {   // 이분 탐색

        boolean flag = false;   // 결과값 찾았는지

        while(S <= E) { // 역전이 아니면 반복
            int mid = (S + E) / 2;  // 중앙값

            if(arr[mid] < t)    // 크면
                S = mid + 1;    // 시작 인덱스 갱신
            else if(arr[mid] > t)   // 작으면
                E = mid - 1;    // 끝 인덱스 갱신
            else {  // 같으면
                flag = true;    // 찾았으므로 true

                break;  // while 종료
            }
        }

        sb.append(flag ? 1 : 0).append("\n");   // 찾았으면 1, 아니면 0과 함께 개행 문자 추가
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        int T = Integer.parseInt(bf.readLine());    // 테스트 케이스

        while(T-- > 0) {    // 개수 만큼
            int N = Integer.parseInt(bf.readLine());    // 크기
            int[] arr = new int[N]; // 초기화

            StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링
            for(int i = 0; i < N; i++)  // 크기만큼
                arr[i] = Integer.parseInt(st.nextToken());  // 입력배열 저장

            Arrays.sort(arr);   // 오름차순 정렬, 이분 탐색하기 위해

            int M = Integer.parseInt(bf.readLine());    // 찾을 개수
            sb = new StringBuilder();   // 문자열 만들기

            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링
            for(int i = 0; i < M; i++) {    // 크기만큼
                int target = Integer.parseInt(st.nextToken());  // 찾을 숫자

                BinarySearch(arr, target, 0, N - 1);    // 이분 탐색
            }

            System.out.print(sb.toString());    // 결과 문자열 출력
        }
    }
}
