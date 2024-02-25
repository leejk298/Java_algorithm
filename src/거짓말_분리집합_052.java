import java.util.*;
import java.io.*;

public class 거짓말_분리집합_052 {
    static int N, M, T;
    static int parent[]; // 집합
    static int trueP[]; // 진실을 아는 사람
    static ArrayList<Integer>[] party; // 파티
    static int res; // 결과

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        N = Integer.parseInt(st.nextToken()); // 사람 수
        M = Integer.parseInt(st.nextToken()); // 파티 수

        parent = new int[N + 1]; // 집합 초기화
        for (int i = 0; i < N + 1; i++) // 집합 설정
            parent[i] = i;

        party = new ArrayList[M]; // 파티 리스트 초기화

        st = new StringTokenizer(bf.readLine()); // 한 줄 스트링
        T = Integer.parseInt(st.nextToken()); // 진실을 아는 사람 수

        res = 0; // 결과 초기화
        trueP = new int[T]; // 진실 집합 초기화

        for (int i = 0; i < T; i++) // 진실 집합 설정
            trueP[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) { // 파티 수만큼
            party[i] = new ArrayList<Integer>(); // 리스트 구현

            st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

            int partySize = Integer.parseInt(st.nextToken()); // 파티 인원
            for (int j = 0; j < partySize; j++) // 인원만큼
                party[i].add(Integer.parseInt(st.nextToken())); // 리스트에 추가
        }
    }

    public static void union(int a, int b) { // union

        a = find(a);
        b = find(b);

        if (a != b)
            parent[b] = a;
    }

    public static int find(int a) { // find

        if (a == parent[a])
            return a;

        return parent[a] = find(parent[a]); // 리턴 시 현재노드에서 발견한 대표노드를 모든 노드의 대표노드로 갱신
    }

    public static void printResult() {  // 결과 출력

        for (int i = 0; i < M; i++) { // 파티 수만큼
            int firstPeople = party[i].get(0); // 각 파티의 처음 참석인원과

            for (int j = 1; j < party[i].size(); j++) // 해당 파티 총 인원 전부를
                union(firstPeople, party[i].get(j)); // union
        }

        for (int i = 0; i < M; i++) { // 파티 수만큼
            boolean isPossible = true; // 거짓말 가능한지, 초기화
            int cur = party[i].get(0); // 각 파티의 대표노드와

            for (int j = 0; j < trueP.length; j++) { // 진실 집합 크기만큼
                if (find(cur) == find(trueP[j])) { // 진실 집합의 노드들을 비교하여 같으면
                    isPossible = false; // 거짓말 불가능

                    break; // 반복문 종료
                }
            }

            if (isPossible)
                res++; // 거짓말 가능하면 카운트 세기
        }

        System.out.println(res); // 값 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        printResult();  // 결과 출력
    }
}
