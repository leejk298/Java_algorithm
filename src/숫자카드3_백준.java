import java.util.*;
import java.io.*;

/*
10
6 3 2 10 10 10 -10 -10 7 3
8
10 9 -5 2 3 4 5 -10
 */

public class 숫자카드3_백준 {
    static int N, M;    // 크기
    static Map<Integer, Integer> hashMap;   // 해시맵

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 크기
        hashMap = new HashMap<>();  // 초기화

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        for (int i = 0; i < N; i++) {    // 크기만큼
            int num = Integer.parseInt(st.nextToken()); // 숫자
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1); // 해시맵 구현
        }

        M = Integer.parseInt(bf.readLine());    // 크기
        StringBuilder sb = new StringBuilder(); // 결과 문자열

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        for (int i = 0; i < M; i++) {    // 크기만큼
            int num = Integer.parseInt(st.nextToken()); // 숫자

            if (hashMap.containsKey(num))    // 해당 키값이 존재하면
                sb.append(hashMap.get(num) + " ");  // 해당하는 밸류값 추가
            else    // 아니면
                sb.append(0 + " "); // 0 추가
        }

        System.out.println(sb); // 결과 문자열 출력
    }
}
