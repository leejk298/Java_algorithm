import java.io.*;
import java.util.*;

/*
4
Baha enter
Askar enter
Baha leave
Artem enter
 */

public class 회사에있는사람_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        int N = Integer.parseInt(bf.readLine());    // 크기
        Set<String> hashSet = new HashSet<>();  // 해시셋

        for(int i = 0; i < N; i++) {    // 크기만큼
            String[] str = bf.readLine().split(" ");    // 입력 문자열

            String name = str[0];   // 이름

            if(!hashSet.contains(name)) // 해시셋에 포함되어있지 않으면
                hashSet.add(name);  // 추가
            else    // 포함되어 있으면
                hashSet.remove(name);   // 삭제
        }

        List<String> list = new ArrayList<>(hashSet);   // 리스트, 정렬위해

        Collections.sort(list, Collections.reverseOrder()); // 역순

        for(String str : list)  // 순회
            System.out.println(str);    // 결과 출력
    }
}
