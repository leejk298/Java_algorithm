import java.util.*;

public class 이진트리순회_BinaryTree_070 {
    static int tree[][];

    public static void preOrder(int now) { // 전위 순회
        // 베이스 케이스
        if (now == -1) // 자식이 없으면 return
            return;

        // 재귀 케이스
        System.out.print((char) (now + 'A')); // 자신 출력
        preOrder(tree[now][0]); // 왼쪽 자식, 재귀콜
        preOrder(tree[now][1]); // 오른쪽 자식, 재귀콜
    }

    public static void inOrder(int now) { // 중위 순회
        if (now == -1)
            return;

        inOrder(tree[now][0]); // 왼
        System.out.print((char) (now + 'A')); // 자
        inOrder(tree[now][1]); // 오
    }

    public static void postOrder(int now) { // 후위 순회
        if (now == -1)
            return;

        postOrder(tree[now][0]); // 왼
        postOrder(tree[now][1]); // 오
        System.out.print((char) (now + 'A')); // 자
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // 입력

        int N = sc.nextInt(); // 노드 개수
        tree = new int[26][2]; // 트리

        sc.nextLine(); // 숫자 다음 문자를 입력받을 때 꼭 개행제거

        for (int i = 0; i < N; i++) { // 노드 개수만큼
            String str[] = sc.nextLine().split(" "); // 문자열 한 줄 입력받아, 공백을 기준으로

            int node = str[0].charAt(0) - 'A'; // 노드 index
            char left = str[1].charAt(0); // 해당 노드의 왼쪽 자식
            char right = str[2].charAt(0); // 해당 노드의 오른쪽 자식

            if (left == '.') // . 이 오면 자식 X => -1
                tree[node][0] = -1;
            else
                tree[node][0] = left - 'A';

            if (right == '.')
                tree[node][1] = -1;
            else
                tree[node][1] = right - 'A';
        }

        preOrder(0); // 전위 순회 => 자 왼 오
        System.out.println(); // 개행 출력

        inOrder(0); // 중위 순회 => 왼 자 오
        System.out.println();

        postOrder(0); // 후위 순회 => 왼 오 자
        System.out.println();
    }
}
