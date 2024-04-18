import java.util.*;
import java.io.*;

/*
7 Y
lms0806
lms0806
exponentiale
lms0806
jthis
lms0806
leo020630
 */

public class 미니게임_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken());   // 크기
        String genre = st.nextToken();  // 종류

        Set<String> set = new HashSet<>();  // 집합, 중복제거
        for (int i = 0; i < N; i++) // 크기만큼
            set.add(bf.readLine()); // 집합에 추가

        if (genre.equals("Y"))  // 윷놀이, 2
            System.out.println(set.size() / 1); // 자신 제외 => - 1 하고 나누기
        else if (genre.equals("F")) // 같은 그림 찾기, 3
            System.out.println(set.size() / 2);
        else    // 원카드, 4
            System.out.println(set.size() / 3);
    }
}
