import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class 칵테일_유클리드호제법_044 {
    static class cNode {	// cNode 클래스
        int b, p, q;	// 멤버 변수

        public cNode(int b, int p, int q) {	// 멤버 함수 : 매개변수 생성자
            super();	// 부모클래스에 접근

            this.b = b;	// 값 설정
            this.p = p;
            this.q = q;
        }

        public int getB() {	// getter
            return b;
        }

        public int getP() {
            return p;
        }

        public int getQ() {
            return q;
        }
    }

    public static void DFS(int node, ArrayList<cNode>[] A, boolean[] visited, long[] V) {	// DFS

        visited[node] = true;	// 방문한 배열 true로 설정

        for (cNode i : A[node]) {	// 인접리스트를 순회하면서
            int next = i.getB();	// 다음 노드

            if (!visited[next]) {	// 다음 노드가 방문하지않은 노드이면
                V[next] = V[node] * i.getQ() / i.getP();	// 노드값 갱신

                DFS(next, A, visited, V);	// DFS 호출 - 재귀
            }
        }
    }


    public static long gcd(long a, long b) {	// 최대공약수

        if (b == 0)
            return a;

        return gcd(b, a % b);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);	// 입력

        int N = sc.nextInt();	// 크기
        ArrayList<cNode>[] A = new ArrayList[N];	// 인접리스트
        long lcm = 1;	// 최소공배수
        boolean visited[] = new boolean[N];	// 방문배열
        long V[] = new long[N];	// 노드값 저장배열

        for (int i = 0; i < N; i++)	// 인접리스트
            A[i] = new ArrayList<cNode>();	// 연결

        for (int i = 0; i < N - 1; i++) {	// 인접리스트
            int a = sc.nextInt();	// 입력받아
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();

            A[a].add(new cNode(b, p, q));	// 무방향성이므로 양 쪽 다
            A[b].add(new cNode(a, p, q));

            lcm = lcm * (p * q / gcd(p, q));	// 최소공배수 설정
        }

        V[0] = lcm;	// 처음 시작하는 노드값은 최소공배수로 설정
        DFS(0, A, visited, V);	// DFS
        long mgcd = V[0];	// 공약수

        for (int i = 1; i < N; i++)	// 다음 노드부터
            mgcd = gcd(mgcd, V[i]);	// 최대공약수 구하기

        for (int i = 0; i < N; i++)	// 크기 만큼
            System.out.print(V[i] / mgcd + " ");	// 해당 노드를 최대공약수로 나눈 노드값 출력
    }
}
