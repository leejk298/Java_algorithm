import java.util.*;
import java.io.*;

/*
3 5
1 2 4
2 3 4 5 6
 */

public class 대칭차집합_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken());   // 집합 A
        int M = Integer.parseInt(st.nextToken());   // B

        Set<Integer> set = new HashSet<>(); // 해시셋

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링
        for(int i = 0; i < N; i++)  // 집합 A
            set.add(Integer.parseInt(st.nextToken()));  // 해시셋에 추가

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링
        for(int i = 0; i < M; i++)  // 집합 B
            set.add(Integer.parseInt(st.nextToken()));  // 해시셋에 추가

        int sum = N + M;    // 총 개수
        int size = set.size();  // 중복제거한 개수
        int count = sum - size; // 교집합 개수

        System.out.println(N - count + M - count);  // 차집합의 합 출력
    }
}
