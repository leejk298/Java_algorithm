import java.util.*;
import java.io.*;

/*
30 42 70 35 90
 */

public class 대부분의배수_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int[] arr = new int[5]; // 입력배열

        for (int i = 0; i < 5; i++) // 크기만큼
            arr[i] = Integer.parseInt(st.nextToken());  // 입력배열 저장

        int answer = 0, count = 0;  // 결과값, 개수

        while (true) {
            answer++;   // 결과값 카운트

            for (int i = 0; i < 5; i++) // 크기만큼
                if (answer % arr[i] == 0)   // 나누어 떨어지면
                    count++;    // 개수 카운트

            if (count >= 3) // 3개 이상이면
                break;  // while 종료

            count = 0;  // 3개 이상이 아니면 개수 초기화
        }

        System.out.println(answer); // 결과값 출력
    }
}
