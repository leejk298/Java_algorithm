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

        if (a == parent[a]) // 같으면
            return a;   // 그대로

        return parent[a] = find(parent[a]); // 다르면 부모배열까지 갱신 후 리턴
    }

    public static void union(int a, int b) { // 합집합

        a = find(a);    // a의 대표노드
        b = find(b);

        if (a != b) // 다르면
            parent[b] = a;  // 합집합
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 크기

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        M = Integer.parseInt(st.nextToken());   // 크기

        parent = new int[N + 1];    // 부모배열 초기화
        for (int i = 1; i <= N; i++)    // 크기만큼
            parent[i] = i;  // 저장

        for (int i = 1; i <= N; i++) {  // 행
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            for (int j = 1; j <= N; j++) {  // 열
                int num = Integer.parseInt(st.nextToken()); // 연결여부

                if (num == 1)   // 연결되어 있으면
                    union(i, j);    // 합집합
            }
        }

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int s = Integer.parseInt(st.nextToken());   // 시작도시
        boolean flag = true;    // 방문여부

        for (int i = 1; i < M; i++) {   // 크기 -1 만큼
            int e = Integer.parseInt(st.nextToken());   // 도착도시

            if (find(s) != find(e)) {   // 두 도시의 대표노드가 다르면
                flag = false;   // 방문 불가능

                break;  // for 종료
            }
        }

        if (flag)   // 방문 가능하면
            System.out.println("YES");  // YES 출력
        else    // 아니면
            System.out.println("NO");   // NO 출력
    }
}
