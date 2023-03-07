import java.util.*;

public class 자동완성_프로그래머스 {
    public static void main(String[] args) {
        String[] words = new String[] {"word","war","warrior","world"};

        Solution solution = new Solution();
        System.out.println(solution.solution(words));
    }

    static class Solution {

        public class Node { // Node 클래스

            // 멤버 변수로 해시맵과 자식개수를 가짐
            private HashMap<Character, Node> childNodes = new HashMap<>();
            private int count;
        }

        public class Trie { // Trie 클래스

            // 멤버 변수로 Node 클래스의 객체 root노드를 가짐
            Node root;

            // 멤버 함수 3개
            public Trie() { // 생성자
                root = new Node();
            }

            public void insert(String word) {   // 삽입
                Node nowNode = this.root;   // 루트노드에 연결

                for(int i = 0; i < word.length(); i++) {    // 단어 길이만큼
                    nowNode = nowNode.childNodes.computeIfAbsent(word.charAt(i), n -> new Node());  // 자식노드 할당
                    nowNode.count++;    // 부모노드의 자식개수 + 1
                }
            }

            public int getCount(String word) {  // 개수 세기
                int nowCount = 0;   // 자식개수
                Node nowNode = this.root;   // 루트노드에 연결

                for(int i = 0; i < word.length(); i++) {    // 단어 길이만큼
                    char ch = word.charAt(i);   // 단어 하나씩
                    Node node = nowNode.childNodes.get(ch); // 해당 단어의 노드로 이동
                    nowCount++; // 깊이, 자식개수 + 1

                    if(node.count == 1) // 자식이 없으면, 리프노드이면
                        return nowCount;    // 총 깊이 출력

                    // 자식이 있으면
                    nowNode = node; // 자식노드에 연결
                }

                // 반복문 종료되면 단어 길이만큼 검색해야하므로
                return nowCount;    // 총 깊이 출력
            }
        }

        public int solution(String[] words) {
            int answer = 0;

            Trie trie = new Trie(); // Trie 클래스 객체 생성

            for(String w : words)   // 순회
                trie.insert(w);     // 삽입

            for(String w : words)   // 순회
                answer += trie.getCount(w); // 개수 카운트

            return answer;  // 총 개수 출력
        }
    }
}
