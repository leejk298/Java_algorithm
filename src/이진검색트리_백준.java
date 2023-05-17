import java.util.*;
import java.io.*;

public class 이진검색트리_백준 {
    static Node root;   // 루트노드

    static class Node { // 노드 클래스
        int num;    // 데이터
        Node l, r;  // 왼, 오른쪽 자식 노드

        public Node(int num) {  // 생성자
            this.num = num;
        }

        public void insert(int num) {   // 멤버 함수

            if(num < this.num) {    // 작으면, 왼쪽 자식 노드 이동
                if(this.l == null)  // 해당 노드가 비어있으면
                    this.l = new Node(num); // 삽입
                else    // 이미 존재하면
                    this.l.insert(num); // 재귀콜

            } else {    // 크면, 오른쪽 자식 노드
                if(this.r == null)
                    this.r = new Node(num);
                else
                    this.r.insert(num);
            }
        }
    }

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        root = new Node(Integer.parseInt(bf.readLine()));   // 루트노드 생성

        while(true) {
            String str = bf.readLine(); // 한 줄 스트링

            if(str == null || str.equals(""))   // 문자열이 null 이거나 null 문자인 경우
                break;

            root.insert(Integer.parseInt(str)); // 아니면 삽입
        }
    }

    public static void postOrder(Node node) {   // 후위순회

        if(node == null)    // 베이스케이스
            return;

        // 재귀케이스
        postOrder(node.l);  // 왼
        postOrder(node.r);  // 오
        System.out.println(node.num);   // 자
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        postOrder(root);    // 루트노드로 후위순회 출력
    }
}
