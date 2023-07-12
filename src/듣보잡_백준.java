import java.util.*;
import java.io.*;

/*
3 4
ohhenrie
charlie
baesangwook
obama
baesangwook
ohhenrie
clinton
 */

public class 듣보잡_백준 {
    static int N, M;    // 크기
    static Set<String> set; // 입력 해시셋
    static List<String> list;   // 결과 리스트

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 입력
        M = Integer.parseInt(st.nextToken());   // 비교할 크기

        // 초기화
        set = new HashSet<>();
        list = new ArrayList<>();

        for(int i = 0; i < N; i++)  // 입력 크기
            set.add(bf.readLine()); // 해시셋 추가

        for(int i = 0; i < M; i++) {    // 결과
            String str = bf.readLine(); // 문자열

            if(set.contains(str))   // 포함되어 있으면
                list.add(str);  // 결과 리스트에 저장
        }
    }

    public static void printResult() {  // 결과 출력

        Collections.sort(list); // 오름차순 정렬

        System.out.println(list.size());    // 크기 출력
        for(String str : list)  // 결과 리스트 순회
            System.out.println(str);    // 문자열 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        printResult();  // 결과 출력
    }
}
