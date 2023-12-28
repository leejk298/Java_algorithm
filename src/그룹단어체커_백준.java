import java.util.*;
import java.io.*;

/*
4
aba
abab
abcabc
a
 */

public class 그룹단어체커_백준 {

    public static boolean isValidWord(String str) { // 단어가 유효한지

        boolean[] visited = new boolean[26];    // 알파벳 방문배열
        char prev = '\0';   // 이전 문자 초기화

        for(int i = 0; i < str.length(); i++) { // 길이만큼
            char now = str.charAt(i);   // 현재 문자

            if(prev != now) {   // 다르면
                if(!visited[now - 'a']) {   // 방문한 적이 없으면
                    visited[now - 'a'] = true;  // 방문
                    prev = now; // 이전 문자 갱신
                } else  // 방문한 적이 있으면
                    return false;   // 연속하지 않으므로 그룹 단어 x
            } else  // 같으면
                continue;   // 연속하므로 다음 단어로 건너뛰기
        }

        return true;  // 여기에 도달하면 true
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        int N = Integer.parseInt(bf.readLine());    // 단어 개수

        int count = 0;  // 총 개수
        for (int i = 0; i < N; i++) // 개수 만큼
            if(isValidWord(bf.readLine()))  // 유효하면
                count++;    // 개수 카운트

        System.out.println(count);  // 총 개수 출력
    }
}
