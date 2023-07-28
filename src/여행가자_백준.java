import java.util.*;
import java.io.*;

/*
3
3
0 1 0
1 0 1
0 1 0
1 2 3
 */

public class 여행가자_백준 {
    static int N, M;    // 크기
    static int[] parent;    // 부모배열

    public static int find(int a) { // find

        if(a == parent[a])  // 같으면
            return a;   // 그대로 리턴

        // 다르면 부모배열 갱신 후 리턴
        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {    // 합집합

        a = find(a);    // 대표노드 찾기
        b = find(b);

        if(a != b)  // 다르면
            parent[b] = a;  // 합집합
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st;

        N = Integer.parseInt(bf.readLine());    // 크기
        M = Integer.parseInt(bf.readLine());

        // 초기화
        parent = new int[N + 1];
        for(int i = 1; i <= N; i++)
            parent[i] = i;

        for(int i = 1; i <= N; i++) {   // 행
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            for(int j = 1; j <= N; j++) {   // 열
                int num = Integer.parseInt(st.nextToken()); // 여행 경로

                if(num == 1)    // 여행 가능하면
                    union(i, j);    // 합집합
            }
        }

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링
        int start = Integer.parseInt(st.nextToken());   // 시작 도시
        boolean flag = true;    // 초기화

        for(int i = 1; i < M; i++) {    // M - 1 개 도시에 대해
            int end = Integer.parseInt(st.nextToken()); // 도착 도시

            if(find(start) != find(end)) {  // 여행이 불가능하면
                flag = false;   // false

                break;  // for 종료
            }
        }

        if(flag)    // 여행 가능하면
            System.out.println("YES");
        else    // 불가능하면
            System.out.println("NO");
    }
}
