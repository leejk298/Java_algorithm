import java.util.*;
import java.io.*;

/*
5
4 1 5 2 3
5
1 3 7 9 5
 */

public class 수찾기2_백준 {
    static int N, M;    // 크기
    static Map<Integer, Integer> hashMap;   // 해시맵

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 크기
        hashMap = new HashMap<>();  // 초기화

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링
        for(int i = 0; i < N; i++) {    // 크기만큼
            int num = Integer.parseInt(st.nextToken()); // 숫자

            hashMap.put(num, 1);    // 해시맵에 추가
        }

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링
        M = Integer.parseInt(st.nextToken());      // 크기

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링
        for(int i = 0; i < M; i++) {    // 크기만큼
            int num = Integer.parseInt(st.nextToken()); // 숫자

            if(hashMap.containsKey(num))    // 해시맵에 존재하면
                System.out.println(hashMap.get(num));   // 1 출력
            else    // 아니면
                System.out.println(0);  // 0 출력
        }
    }
}
