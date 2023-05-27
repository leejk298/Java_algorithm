import java.util.*;
import java.io.*;

/*
3
deed
mean
demeaned
 */

public class 복습2번_1 {   // 내가 푼 방법
    static int N;   // 크기
    static String[] st; // 입력배열
    static List<String> list;   // 결과배열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        N = Integer.parseInt(bf.readLine());    // 크기, 한 줄 스트링

        // 초기화
        st = new String[N];
        for(int i = 0; i < N; i++)
            st[i] = bf.readLine();
    }

    public static void addStringList() {    // 리스트에 추가

        list = new ArrayList<>();   // 초기화

        for(int i = 0; i < N; i++) {    // 크기만큼
            String str = st[i]; // 문자열 하나씩
            int len = st[i].length();   // 길이

            for(int k = 1; k < len; k++) {  // 양 끝을 제외한 가운데 인덱스에 문자열 삽입
                String tmp = null;  // 저장할 문자열

                for(int j = 0; j < N; j++) {    // 크기만큼
                    tmp = str.substring(0, k) + st[j] + str.substring(k, len);  // 가운데에 하나씩 붙이기
                    list.add(tmp);  // 리스트에 추가
                }
            }
        }
    }

    public static void printCount() {   // 개수 출력

        int count = 0;  // 개수

        for(int i = 0; i < N; i++)  // 입력 크기만큼
            for(int j = 0; j < list.size(); j++)    // 리스트 크기만큼
                if(list.get(j).equals(st[i]))   // 비교하여 같으면
                    count++;    // 개수 카운트

        System.out.println(count);  // 총 개수 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화, O(N)

        addStringList();    // 리스트 추가, O(N^2 * len - 1) => O(N^2), len: 문자열 길이

        printCount();   // 개수 출력, O(N^3) => list 크기가 최대 O(N^2)이므로 => 최적화 필요 => 해시맵 이용
    }
}
