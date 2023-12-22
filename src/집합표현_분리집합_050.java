import java.util.*;

public class 집합표현_분리집합_050 {

    public static boolean checkSame(int a, int b, int[] parent) { // 두 수가 같은지

        a = find(a, parent); // find 연산
        b = find(b, parent);

        if (a == b) // 같은지 체크
            return true;

        return false;
    }

    public static void union(int a, int b, int[] parent) { // union

        a = find(a, parent);
        b = find(b, parent);

        if (a != b) // 다르면
            parent[b] = a; // 연결

        // 같으면 서로 같은 집합이므로 로직 필요 x
    }

    public static int find(int a, int[] parent) { // find

        if (a == parent[a]) // index와 value가 같으면
            return a; // 대표노드가 자기자신이므로 자신 리턴

        return parent[a] = find(parent[a], parent); // 현재노드에서 발견한 대표노드를 모든 노드의 대표노드로 갱신
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // 입력

        int N = sc.nextInt(); // 크기
        int M = sc.nextInt(); // 연산 개수
        int parent[] = new int[N + 1]; // 집합 배열

        for (int i = 0; i < N + 1; i++) // 초기화
            parent[i] = i;

        for (int i = 0; i < M; i++) { // 연산 개수만큼
            int t = sc.nextInt(); // 무슨 연산
            int a = sc.nextInt(); // 숫자 1
            int b = sc.nextInt(); // 숫자 2

            if (t == 0) // union
                union(a, b, parent);

            else { // 두 수가 같은지
                if (checkSame(a, b, parent))
                    System.out.println("YES");

                else
                    System.out.println("NO");
            }
        }
    }
}
