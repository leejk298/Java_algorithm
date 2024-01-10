import java.util.*;
import java.io.*;

/*
3
1 2 3
 */

public class 피시방알바_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        boolean[] visited = new boolean[101];   // 방문배열

        int N = Integer.parseInt(st.nextToken());   // 크기
        int count = 0;  // 거절당한 수

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링
        for(int i = 0; i < N; i++) {    // 크기만큼
            int num = Integer.parseInt(st.nextToken()); // 좌석

            if(!visited[num])   // 방문한 적이 없으면
                visited[num] = true;    // 방문
            else    // 방문한 적이 있으면
                count++;    // 거절 개수 카운트
        }

        System.out.println(count);  // 결과 출력
    }
}
