import java.util.*;
import java.io.*;

/*
4 3
0
2 1 2
1 3
3 2 3 4
 */

public class 거짓말_백준 {
    static int N, M, K; // 크기
    static List<Integer>[] A;   // 인접리스트
    static int[] parent, trueMan;   // 부모배열, 진실배열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 사람
        M = Integer.parseInt(st.nextToken());   // 파티

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        K = Integer.parseInt(st.nextToken());   // 진실을 아는사람

        trueMan = new int[K];   // 진실배열
        for (int i = 0; i < K; i++) // 크기만큼
            trueMan[i] = Integer.parseInt(st.nextToken());  // 저장

        parent = new int[N + 1];    // 부모배열
        for (int i = 1; i <= N; i++)    // 크기만큼
            parent[i] = i;  // 저장

        A = new List[M];    // 인접리스트
        for (int i = 0; i < M; i++) {   // 크기만큼
            A[i] = new ArrayList<>();   // 초기화

            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int size = Integer.parseInt(st.nextToken());    // 크기

            for (int j = 0; j < size; j++)  // 크기만큼
                A[i].add(Integer.parseInt(st.nextToken())); // 저장
        }
    }

    public static int find(int a) { // find

        if (parent[a] == a) // 베이스케이스: 초기화 상태이면
            return a;   // 그대로 리턴

        // 재귀케이스: 초기화 상태가 아니면
        return parent[a] = find(parent[a]); // 부모 값도 갱신
    }

    public static void union(int a, int b) {    // 합집합

        a = find(a);    // a
        b = find(b);    // b

        if (a != b) // 서로 다르면
            parent[b] = a;  // 합집합
    }

    public static boolean isSame(int a, int b) {    // 서로 같은지

        if (find(a) == find(b)) // 같으면
            return true;    // true

        return false;   // 다르면 false
    }

    public static int findMaxCount() {  // 최대값 찾기

        for (int i = 0; i < M; i++) {   // 파티 수만큼
            int now = A[i].get(0);  // 파티 오는 사람

            for (int j = 1; j < A[i].size(); j++)   // 인접리스트 크기만큼
                union(now, A[i].get(j));    // 합집합
        }

        int count = 0;  // 개수
        for (int i = 0; i < M; i++) {   // 파티 수만큼
            int now = A[i].get(0);  // 파티 오는 사람
            boolean flag = true;    // 거짓인지

            for (int j = 0; j < K; j++) {   // 진실을 말하는 사람 수만큼
                if (isSame(now, trueMan[j])) {  // 같으면
                    flag = false;   // 불참

                    break;  // for j 종료
                }
            }

            if (flag)   // 참이면
                count++;    // 참석하는 사람 카운트
        }

        return count;   // 최대값 리턴
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        System.out.println(findMaxCount()); // 최대값 출력
    }
}
