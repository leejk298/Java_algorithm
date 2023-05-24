import java.util.*;

/*
7
A B C
B D .
C E F
E . .
F . G
D . .
G . .
 */

public class 트리순회_백준 {
    static int N;   // 크기
    static int[][] tree;    // 트리

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    //입력

        N = Integer.parseInt(sc.nextLine());    // 개행포함 한 줄 스트링을 받아서 정수형으로 변환, 크기

        tree = new int[26][2];  // 트리 초기화, 알파벳 26, 왼 오른쪽 자식 2

        for(int i = 0; i < N; i++) {    // 노드 개수만큼
            String str[] = sc.nextLine().split(" ");    // 한 줄 스트링, 공백을 기준으로 나눠서 문자열배열로 저장

            int node = str[0].charAt(0) - 'A';  // 부모노드, 정수형으로 변환 -> 해당 알파벳 인덱스에 저장
            char left = str[1].charAt(0);   // 왼쪽 자식노드
            char right = str[2].charAt(0);  // 오른쪽 자식노드

            if(left == '.') // . 이면
                tree[node][0] = -1; // null
            else    // 아니면
                tree[node][0] = left - 'A'; // 해당 알파벳 인덱스에 저장

            if(right == '.')
                tree[node][1] = -1;
            else
                tree[node][1] = right - 'A';
        }
    }

    public static void preOrder(int v) {    // 전위순회
        // 베이스케이스
        if(v == -1) // 리프노드이면
            return; // 리턴

        // 재귀케이스
        System.out.print((char)(v + 'A'));  // 자
        preOrder(tree[v][0]);   // 왼
        preOrder(tree[v][1]);   // 오
    }

    public static void inOrder(int v) {     // 중위순회

        if(v == -1)
            return;

        inOrder(tree[v][0]);    // 왼
        System.out.print((char)(v + 'A'));  // 자
        inOrder(tree[v][1]);    // 오
    }

    public static void postOrder(int v) {   // 후위순회

        if(v == -1)
            return;

        postOrder(tree[v][0]);  // 왼
        postOrder(tree[v][1]);  // 오
        System.out.print((char)(v + 'A'));  // 자
    }

    public static void main(String[] args) {

        init(); // 초기화

        preOrder(0);    // 전위순회
        System.out.println();   // 개행문자 출력

        inOrder(0); // 중위순회
        System.out.println();

        postOrder(0);   // 후위순회
        System.out.println();
    }
}
