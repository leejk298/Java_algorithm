import java.util.*;

public class 길찾기게임_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println((Arrays.deepToString(solution.solution(new int[][]
                {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}}))));
    }

    static class Solution {
        static Node root;   // 루트노드
        static int[][] answer;  // 결과배열
        static Node[] node; // 트리
        static int index;   // 순회 인덱스

        static class Node { // 노드클래스
            int index;  // 순서
            int x, y;   // 좌표
            Node l, r;  // 자식노드

            public Node(int index, int x, int y, Node l, Node r) {  // 파라미터 생성자
                this.index = index;
                this.x = x;
                this.y = y;
                this.l = l;
                this.r = r;
            }
        }

        public static void init(int[][] nodeinfo) { // 초기화

            answer = new int[2][nodeinfo.length];   // 결과배열
            node = new Node[nodeinfo.length];   // 트리

            for(int i = 0; i < nodeinfo.length; i++)    // 길이만큼
                node[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1], null, null);  // 트리 생성

            Arrays.sort(node, (o1, o2) -> { // 정렬
                if(o1.y == o2.y)    // y값이 같으면 => 레벨이 같으면
                    return o1.x - o2.x; // x값 오름차순 정렬

                return o2.y - o1.y; // y값이 다르면 => y값 내림차순 정렬
            });
        }

        public static void insertNode(Node parent, Node child) {    // 노드삽입

            if(parent.x > child.x) {    // 왼쪽 서브트리
                if(parent.l == null)    // 왼쪽 자식노드가 없으면
                    parent.l = child;   // 연결
                else    // 있으면
                    insertNode(parent.l, child);    // 재귀콜
            } else {    // 오른쪽 서브트리
                if(parent.r == null)
                    parent.r = child;
                else
                    insertNode(parent.r, child);
            }
        }

        public static void makeTree() { // 트리 만들기

            root = node[0]; // 루트노드

            for(int i = 1; i < node.length; i++)    // 길이만큼
                insertNode(root, node[i]);  // 노드 삽입
        }

        public static void preOrder(Node node) {    // 전위순회: 자 -> 왼 -> 오

            if(node == null)    // 베이스케이스: 리프노드의 자식노드인 경우
                return;

            // 재귀케이스: 리프노드의 자식노드가 아니면
            answer[0][index++] = node.index;    // 자신
            preOrder(node.l);   // 왼쪽 자식노드
            preOrder(node.r);   // 오른쪽 자식노드
        }

        public static void postOrder(Node node) {   // 후위순회: 왼 -> 오 -> 자

            if(node == null)    // 베이스케이스
                return;

            // 재귀케이스
            postOrder(node.l);  // 왼쪽 자식노드
            postOrder(node.r);  // 오른쪽 자식노드
            answer[1][index++] = node.index;    // 자신
        }

        public static void printTree() {    // 트리 출력

            index = 0;  // 인덱스 초기화
            preOrder(root); // 루트노드로 전위순회

            index = 0;
            postOrder(root);    // 후위순회
        }

        public int[][] solution(int[][] nodeinfo) {

            init(nodeinfo); // 초기화

            makeTree(); // 트리 만들기

            printTree(); // 트리 출력

            return answer;  // 결과배열 리턴
        }
    }
}
