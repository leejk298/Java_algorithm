import java.io.*;
import java.util.StringTokenizer;

/*
seungjaehwang
4
a 0 5
a 0 6
a 6 10
a 7 10
 */

public class 상호작용_백준 {
    static int N;   // 크기
    static int[] alphabetMap;   // 알파벳
    static int[][] alphabet;    // 누적합 배열

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        String S = br.readLine();   // 문자열
        N = Integer.parseInt(br.readLine());    // 크기

        // 초기화
        alphabetMap = new int[26];
        alphabet = new int[S.length()][26];

        for (int i = 0; i < S.length(); i++) {  // 길이만큼
            alphabetMap[S.charAt(i) - 'a']++;   // 알파벳 인덱스 저장

            for (int j = 0 ; j < 26; j++) { // 26개 중에
                alphabet[i][j] = alphabetMap[j];    // 저장
            }
        }

        StringBuilder sb = new StringBuilder(); // 문자열 만들기

        for (int i = 0; i < N; i++) {   // 크기만큼
            String[] str = br.readLine().split(" ");    // 공백 기준으로 나눠

            char c = str[0].charAt(0);  // 찾을 문자
            int s = Integer.parseInt(str[1]);   // 시작
            int e = Integer.parseInt(str[2]);   // 끝 인덱스

            int count = 0;  // 개수
            count = alphabet[e][c - 'a'];   // 최대 개수

            if (s != 0) {   // 구간 시작이 0이 아니면
                count -= alphabet[s - 1][c - 'a'];  // 개수 빼주고
            }

            sb.append(count).append("\n");  // 개행 추가
        }

        System.out.print(sb);   // 출력
    }
}
