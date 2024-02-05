import java.util.*;

public class 문자열찾기_Tree_069 {
    static class tNode {
        tNode[] next = new tNode[26]; // 알파벳 개수만큼
        boolean isEnd; // 배열에 끝인 지 체크
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // 입력

        int N = sc.nextInt(); // 입력개수
        int M = sc.nextInt(); // 체크개수

        tNode root = new tNode(); // 루트노드 생성

        while (N > 0) { // 입력 개수만큼
            String str = sc.next(); // 한 줄 스트링

            tNode now = root; // 루트노드 설정

            for (int i = 0; i < str.length(); i++) { // 스트링 길이만큼
                char ch = str.charAt(i); // 문자 하나씩 검사
                if (now.next[ch - 'a'] == null) // 해당 문자가 없으면
                    now.next[ch - 'a'] = new tNode(); // 노드 하나 할당

                now = now.next[ch - 'a']; // 해당 문자의 루트노드로 설정
                if (i == str.length() - 1) // 문자열이 끝나면
                    now.isEnd = true; // 해당 문자 종료를 나타냄
            }

            N--; // 입력 개수 하나씩 감소
        }

        int cnt = 0; // 포함돼있는 문자열 개수

        while (M > 0) { // 체크할 개수만큼
            String text = sc.next(); // 한 줄 스트링

            tNode now = root; // 루트노드로 설정

            for (int i = 0; i < text.length(); i++) { // 스트링 길이만큼
                char ch = text.charAt(i); // 문자 하나씩 검사

                if (now.next[ch - 'a'] == null) // 문자열이 끝나면
                    break; // 해당 문자열 검사 종료

                now = now.next[ch - 'a']; // 해당 문자가 있으면 다음 문자로 넘어감
                if (i == text.length() - 1 && now.isEnd) // 문자열이 끝나고 종료를 만나면
                    cnt++; // 포함돼있는 문자열이므로 개수 카운트
            }

            M--; // 체크할 개수 하나씩 감소
        }

        System.out.println(cnt); // 개수 출력
    }
}