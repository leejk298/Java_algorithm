import java.util.*;
import java.io.*;

/*
6
9
2 7 4 1 5 3
 */

public class 주몽_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken());   // 크기

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링
        int M = Integer.parseInt(st.nextToken());   // 총 합

        int[] arr = new int[N]; // 초기화

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링
        for(int i = 0; i < N; i++)  // 크기만큼
            arr[i] = Integer.parseInt(st.nextToken());  // 입력배열 저장

        Arrays.sort(arr);   // 오름차순 정렬

        int i = 0, j = N - 1, count = 0;    // 양 끝 인덱스, 개수
        while(i < j) {  // 역전이 아니면
            if(arr[i] + arr[j] < M) // 총 합보다 작으면
                i++;    // 커져야함
            else if(arr[i] + arr[j] > M)    // 크면
                j--;    // 작아져야함
            else {  // 같으면
                count++;    // 개수 카운트
                i++;    // 인덱스 갱신
                j--;
            }
        }

        System.out.println(count);  // 총 개수 출력
    }
}
