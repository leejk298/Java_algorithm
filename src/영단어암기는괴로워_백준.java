import java.util.*;
import java.io.*;

/*
7 4
apple
ant
sand
apple
append
sand
sand
 */

public class 영단어암기는괴로워_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken());   // 크기
        int M = Integer.parseInt(st.nextToken());   // 글자 길이

        Map<String, Integer> hashMap = new HashMap<>(); // 해시맵

        for (int i = 0; i < N; i++) {   // 크기만큼
            String str = bf.readLine(); // 입력문자열

            if (str.length() < M)   // 길이가 M보다 작으면
                continue;   // 건너띄기

            // M 이상이면
            hashMap.put(str, hashMap.getOrDefault(str, 0) + 1); // 해시맵에 저장
        }

        List<String> list = new ArrayList<>(hashMap.keySet());  // 정렬하기 위해 키값을 리스트로 구현

        Collections.sort(list, new Comparator<String>() {   // 정렬
            @Override
            public int compare(String o1, String o2) {  // 함수 재정의
                int count1 = hashMap.get(o1), count2 = hashMap.get(o2); // 문자열에 해당하는 밸류값

                if (count1 == count2) { // 밸류값이 같으면
                    if (o1.length() == o2.length()) // 문자열 길이가 같으면
                        return o1.compareTo(o2);    // 사전 순 정렬
                    else    // 길이가 다르면
                        return o2.length() - o1.length();   // 내림차순 => 길이가 긴 순으로
                } else  // 밸류값이 다르면
                    return count2 - count1; // 내림차순 => 자주 나온 순으로
            }
        });

        StringBuilder sb = new StringBuilder(); // 결과문자열

        for (String str : list) // 리스트 순회
            sb.append(str + "\n");  // 개행문자 추가하여 문자열 하나씩 저장

        System.out.print(sb);   // 결과 출력
    }
}
