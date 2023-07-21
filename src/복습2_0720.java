import java.util.*;

public class 복습2_0720 {
    static int length;  // 문자열 길이
    static Set<String> set; // 해시셋
    static List<String> list;   // 결과리스트
    static String letter;   // 입력 문자열
    static boolean[] visited;   // 방문배열

    public static boolean isValidString(String str) {   // 유효한 문자열인지 확인

        for (int i = 0; i < str.length() - 1; i++)  // 문자열 길이만큼
            if (str.charAt(i) == str.charAt(i + 1)) // 이웃한 문자가 같으면
                return false;   // false

        return true;    // 다 다르면 true
    }

    public static void DFS(int depth, String str) { // DFS, 브루트포스

        if (depth == length) {  // 길이에 도달하면
            if (isValidString(str)) // 유효하면
                set.add(str);   // 해시셋에 저장, 겹칠 수 있으므로 중복 제거

            return; // 완전 탐색하기 위해
        }

        // 길이에 도달하지 못하면
        for (int i = 0; i < length; i++) {  // 길이만큼
            if(visited[i])  // 방문한 적이 있으면
                continue;   // 건너뛰기

            // 방문한 적이 없으면
            visited[i] = true;  // 방문
            str += letter.charAt(i);    // 문자열 갱신

            DFS(depth + 1, str);    // DFS, 재귀콜

            visited[i] = false; // 리턴되면 방문여부 갱신
            str = str.substring(0, depth);  // 문자열 다시 갱신
        }
    }

    public static void init(String letters) {   // 초기화

        letter = letters;   // 문자열
        length = letters.length();  // 길이
        set = new HashSet<>();  // 해시셋
        visited = new boolean[length];  // 방문배열
    }

    public static String[] solution(String letters) {

        init(letters);  // 초기화

        DFS(0, ""); // DFS

        list = new ArrayList<>(set);    // 결과리스트
        Collections.sort(list); // 오름차순 정렬

        return list.stream().toArray(String[]::new);    // 문자열배열로 형변환하여 리턴
    }

    public static void main(String[] args) {

        String letters = "abca";

        System.out.println(Arrays.toString(solution(letters)));
    }
}
