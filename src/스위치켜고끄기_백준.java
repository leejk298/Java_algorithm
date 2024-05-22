import java.util.*;
import java.io.*;

/*
8
0 1 0 1 0 0 0 1
2
1 3
2 3
 */

public class 스위치켜고끄기_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken());   // 크기

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int[] arr = new int[N]; // 결과배열
        for (int i = 0; i < N; i++) // 크기만큼
            arr[i] = Integer.parseInt(st.nextToken());  // 결과배열 저장

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int M = Integer.parseInt(st.nextToken());   // 학생 수

        for (int i = 0; i < M; i++) {   // 학생 수만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int sex = Integer.parseInt(st.nextToken()); // 성별
            int num = Integer.parseInt(st.nextToken()); // 숫자

            if (sex == 1) { // 남학생
                for (int j = 0; j < N; j++) // 크기만큼
                    if ((j + 1) % num == 0) // 배수이면
                        arr[j] = (arr[j] == 0 ? 1 : 0); // 스위치 상태 갱신
            } else {    // 여학생
                arr[num - 1] = (arr[num - 1] == 0 ? 1 : 0); // 상태 저장

                for (int j = 1; j < N / 2; j++) {   // 절반만큼
                    if (num - 1 + j >= N || num - 1 - j < 0)
                        break;

                    if (arr[num - 1 - j] == arr[num - 1 + j]) { // 대칭이면
                        arr[num - 1 - j] = (arr[num - 1 - j] == 0 ? 1 : 0); // 상태갱신
                        arr[num - 1 + j] = (arr[num - 1 + j] == 0 ? 1 : 0);
                    } else  // 대칭이 아니면
                        break;  // for 종료
                }
            }
        }

        for (int i = 0; i < N; i++) {   // 크기만큼
            System.out.print(arr[i] + " "); // 결과 출력

            if ((i + 1) % 20 == 0)  // 20개씩 나누어서
                System.out.println();   // 개행문자 출력
        }
    }
}
