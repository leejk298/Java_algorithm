import java.io.*;
import java.util.StringTokenizer;

/*
adaabc aababbc
 */
public class 문자열_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        String a = st.nextToken();  // 입력문자열
        String b = st.nextToken();

        int answer = a.length();    // 결과값

        for (int i = 0; i <= b.length() - a.length(); i++) {    // 길이의 차이만큼
            int count = 0;  // 개수

            for (int j = 0; j < a.length(); j++)    // 기준 문자열 길이만큼
                if (a.charAt(j) != b.charAt(i + j)) // 같지 않으면
                    count++;    // 개수 카운트

            answer = Math.min(answer, count);   // 최소값 갱신
        }

        System.out.println(answer); // 결과값 출력
    }
}
