import java.util.*;

public class 길찾기게임_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println((Arrays.deepToString(solution.solution(new int[][]
                {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}}))));
    }

    static class Solution {
        static int index;   // 노드 인덱스
        static int[][] answer;  // 결과배열

        public class Node { // Node 클래스
            // 멤버 변수
            int x, y, w;    // 좌표, 인덱스
            Node l, r;  // 자식

            // 멤버 함수
            public Node(int x, int y, int w, Node l, Node r) {  // 생성자
                this.x = x;
                this.y = y;
                this.w = w;
                this.l = l;
                this.r = r;
            }
        }

        public void preOrder(Node root) {   // 전위 순회: 자 왼 오

            if(root == null)    // 베이스 케이스
                return;

            // 재귀 케이스
            answer[0][index++] = root.w;    // 자
            preOrder(root.l);   // 왼
            preOrder(root.r);   // 오
        }

        public void postOrder(Node root) {  // 후위 순회: 왼 오 자

            if(root == null)    // 베이스 케이스
                return;

            // 재귀 케이스
            postOrder(root.l);  // 왼
            postOrder(root.r);  // 오
            answer[1][index++] = root.w;    // 자
        }

        public void insertNode(Node parent, Node child) {   // 트리 만들기

            if(parent.x > child.x) {    // x값 작으면
                if(parent.l == null)    // 왼쪽이 제일 작음
                    parent.l = child;
                else    // 왼쪽 자식이 있으면 해당 노드로 이동, 재귀
                    insertNode(parent.l, child);
            } else {    // x값이 크면
                if(parent.r == null)    // 오른쪽
                    parent.r = child;
                else
                    insertNode(parent.r, child);
            }
        }

        public int[][] solution(int[][] nodeinfo) {

            answer = new int[2][nodeinfo.length];   // 결과배열 선언
            Node[] node = new Node[nodeinfo.length];    // 노드

            for(int i = 0; i < nodeinfo.length; i++)    // 크기만큼
                node[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1, null, null);  // 초기화

            Arrays.sort(node, new Comparator<Node>() {  // 정렬
                @Override
                public int compare(Node o1, Node o2) {
                    if(o1.y == o2.y)    // y값이 같으면
                        return o1.x - o2.x; // x값에 대해 오름차순

                    return o2.y - o1.y; // y값이 다르면 y값에 대해 내림차순
                }
            });

            Node root = node[0];    // 루트노드 => y값이 가장 큰 값
            for(int i = 1; i < node.length; i++)    // 트리 만들기
                insertNode(root, node[i]);

            index = 0;  // 노드 인덱스 초기화
            preOrder(root); // 전위순회

            index = 0;  // 초기화
            postOrder(root);    // 후위순회

            return answer;  // 결과배열 리턴
        }
    }
}
