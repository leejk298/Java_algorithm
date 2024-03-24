import java.util.*;
import java.io.*;

/*
50
30
24
5
28
45
98
52
60
 */

public class 이진검색트리_백준 {
    static Node root;   // 루트 노드

    static class Node { // 노드 클래스
        int v;  // 데이터
        Node l, r;  // 자식 노드

        public Node(int v) {    // 파라미터 생성자
            this.v = v;
        }

        public void insert(int v) { // insert()

            if(v < this.v) {    // 자신보다 작으면 왼쪽
                if(this.l == null)  // 왼쪽 자식 노드가 없으면
                    this.l = new Node(v);   // 생성
                else    // 있으면
                    this.l.insert(v);   // 해당 노드로 재귀콜
            } else {    // 자신보다 크면 오른쪽
                if(this.r == null)  // 오른쪽 자식 노드가 없으면
                    this.r = new Node(v);   // 생성
                else    // 있으면
                    this.r.insert(v);   // 해당 노드로 재귀콜
            }
        }
    }

    public static void postOrder(Node node) {   // 후위순회 - 왼 오 자

        if(node == null)    // 베이스케이스: 리프노드의 자식이면
            return; // 리턴

        // 재귀케이스: 리프노드의 자식이 아니면
        postOrder(node.l);  // 왼
        postOrder(node.r);  // 오
        System.out.println(node.v); // 자
    }

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        root = new Node(Integer.parseInt(bf.readLine()));   // 루트 노드 생성

        while(true) {
            String str = bf.readLine(); // 한 줄 스트링

            if(str == null) // 없으면
                break;  // while 종료

            root.insert(Integer.parseInt(str)); // 있으면 삽입
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        postOrder(root);    // 출력, 후위순회
    }
}
