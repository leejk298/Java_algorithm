import java.util.*;

public class 표편집_프로그래머스 {
    static class Solution {
        class Node {    // 노드 클래스
            Node prev, next;    // 이전, 다음 노드
            boolean isRemoved;  // 삭제유무

            public Node() { // 디폴트 생성자
                prev = null;
                next = null;
                isRemoved = false;
            }
        }

        public String solution(int n, int k, String[] cmd) {

            Stack<Node> stack = new Stack<>();  // 스택
            Node[] node = new Node[n];  // 노드 배열

            for (int i = 0; i < n; i++) // 크기만큼
                node[i] = new Node();   // 초기화

            for (int i = 0; i < n - 1; i++) {   // n - 1
                node[i + 1].prev = node[i]; // 노드 연결
                node[i].next = node[i + 1];
            }

            Node now = node[k]; // 현재 노드
            for (String s : cmd) {  // 명령어
                char ch = s.charAt(0);  // 동작

                if (ch == 'U') {    // U
                    int index = Integer.parseInt(s.substring(2));   // 몇 칸
                    for (int i = 0; i < index; i++) // 크기만큼
                        now = now.prev; // 위로 이동
                } else if (ch == 'D') { // D
                    int index = Integer.parseInt(s.substring(2));   // 몇 칸
                    for (int i = 0; i < index; i++) // 크기만큼
                        now = now.next; // 아래로 이동
                } else if (ch == 'C') { // C
                    stack.push(now);    // 스택에 삽입

                    now.isRemoved = true;   // 삭제
                    Node up = now.prev; // 노드 연결
                    Node down = now.next;

                    if (up != null) // 다음 노드 연결
                        up.next = down;

                    if (down != null) {
                        down.prev = up;
                        now = down;
                    } else  // 삭제된 행이 마지막이면
                        now = up;   // 바로 위 노드 연결
                } else {    // Z
                    Node tmp = stack.pop(); // 스택에서 하나 꺼내어

                    tmp.isRemoved = false;  // 복구
                    Node up = tmp.prev; // 노드 연결
                    Node down = tmp.next;

                    if (up != null) // 다음 노드 연결
                        up.next = tmp;

                    if (down != null)
                        down.prev = tmp;
                }
            }

            StringBuilder sb = new StringBuilder(); // 결과문자열
            for (int i = 0; i < n; i++) {   // 크기만큼
                if (node[i].isRemoved)  // 삭제 되었으면
                    sb.append("X"); // X
                else    // 아니면
                    sb.append("O"); // O
            }

            return sb.toString();   // 결과문자열 리턴
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"}));
    }
}
