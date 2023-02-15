import java.util.*;

public class 여행계획_분리집합_051 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력

        int N = sc.nextInt(); // 여행 도시 개수
        int M = sc.nextInt(); // 여행 루트 크기
        int A[][] = new int[N + 1][N + 1]; // 도시배열
        int parent[] = new int[N + 1]; // 집합

        for (int i = 1; i < N + 1; i++)
            for (int j = 1; j < N + 1; j++)
                A[i][j] = sc.nextInt(); // 도시 배열 초기화, 설정

        int route[] = new int[M + 1]; // 루트 배열 초기화

        for (int i = 1; i < M + 1; i++) // 루트 배열 설정
            route[i] = sc.nextInt();

        for (int i = 1; i < N + 1; i++) // 집합 배열 설정
            parent[i] = i;

        for (int i = 1; i < N + 1; i++)
            for (int j = 1; j < N + 1; j++)
                if (A[i][j] == 1) // 도시끼리 연결되어 있으면
                    union(i, j, parent); // union

        for (int i = 2; i < route.length; i++) { // 루트에 포함되는 노드들의 대표노드가 전부 동일한 지
            if (find(route[1], parent) != find(route[i], parent)) { // find
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    private static int find(int i, int[] parent) { // find
        if (i == parent[i]) // 대표노드이면
            return i;

        return parent[i] = find(parent[i], parent); // 재귀, 리턴 시 현재노드에서 발견한 대표노드를 모든 노드의 대표노드로 갱신
    }

    private static void union(int i, int j, int[] parent) { // union
        i = find(i, parent);
        j = find(j, parent);

        if (i != j) // 다르면
            parent[j] = i; // 연결
    }
}
