import java.util.*;
import java.io.*;

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

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        N = Integer.parseInt(bf.readLine());    // 크기

        // 초기화
        tree = new int[26][2];  // 알파벳, 이진트리
        for(int i = 0; i < N; i++) {    // 크기만큼
            String[] str = bf.readLine().split(" ");    // 한 줄 스트링, 공백기준 나누기

            int node = str[0].charAt(0) - 'A';  // 부모노드
            char l = str[1].charAt(0);  // 왼쪽 자식노드
            char r = str[2].charAt(0);  // 오른쪽 자식노드

            if(l == '.')    // 왼쪽 자식노드가 . 이면
                tree[node][0] = -1; // 리프노드, null
            else    // 아니면
                tree[node][0] = l - 'A';    // 저장

            if(r == '.')    // 오른쪽 자식노드가 . 이면
                tree[node][1] = -1; // 리프노드, null
            else    // 아니면
                tree[node][1] = r - 'A';    // 저장
        }
    }

    public static void preOrder(int v) {    // 전위순회

        // 베이스 케이스
        if(v == -1) // 리프 노드이면
            return; // 리턴

        // 재귀 케이스
        System.out.println((char) (v + 'A'));   // 자
        preOrder(tree[v][0]);    // 왼
        preOrder(tree[v][1]);    // 오
    }

    public static void inOrder(int v) {     // 중위순회

        // 베이스 케이스
        if(v == -1) // 리프 노드이면
            return; // 리턴

        // 재귀 케이스
        inOrder(tree[v][0]);    // 왼
        System.out.println(v);   // 자
        inOrder(tree[v][1]);    // 오
    }

    public static void postOrder(int v) {   // 후위순회

        // 베이스 케이스
        if(v == -1) // 리프 노드이면
            return; // 리턴

        // 재귀 케이스
        postOrder(tree[v][0]);  // 왼
        postOrder(tree[v][1]);  // 오
        System.out.println(v);   // 자
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        preOrder(0);    // 전위순회
        System.out.println();   // 개행문자 출력

        inOrder(0); // 중위순회
        System.out.println();

        postOrder(0);   // 후위순회
        System.out.println();
    }
}
