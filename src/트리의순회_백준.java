import java.util.*;

/*
3
1 2 3
1 3 2
 */

public class 트리의순회_백준 {
    static int[] inOrder, postOrder, root;  // 중위, 후위, 루트인덱스 배열
    static int N;   // 크기

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기

        // 초기화
        inOrder = new int[N];
        postOrder = new int[N];
        root = new int[N + 1];

        for(int i = 0; i < N; i++)
            inOrder[i] = sc.nextInt();  // 중위순회

        for(int i = 0; i < N; i++)
            postOrder[i] = sc.nextInt();    // 후위순회

        for(int i = 0; i < N; i++)
            root[inOrder[i]] = i;   // 루트인덱스
    }

    public static void preOrder(int inStart, int inEnd, int postStart, int postEnd) {   // 전위순회

        if(inStart > inEnd || postStart > postEnd)  // 베이스케이스
            return;

        // 재귀 케이스
        int rootNode = postOrder[postEnd];  // 후위순회 마지막 값은 루트
        System.out.print(rootNode + " ");   // 루트값 출력

        int rootIndex = root[rootNode]; // 루트 인덱스
        int left = rootIndex - inStart; // 왼쪽 자식 범위

        preOrder(inStart, rootIndex - 1, postStart, postStart + left - 1);  // 왼쪽 자식
        preOrder(rootIndex + 1, inEnd, postStart + left, postEnd - 1);  // 오른쪽 자식
    }

    public static void main(String[] args) {

        init(); // 초기화

        preOrder(0, N - 1, 0, N - 1);   // 전위순회
    }
}
