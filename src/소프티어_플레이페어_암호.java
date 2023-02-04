import java.io.*;
import java.util.*;

/*
* 입력
HELLOWORLD
PLAYFAIRCIPHERKEY
* 출력
EIYVRVVQBRGW
* 입력
LEMONSTRAWBERRYAPPLEIUICE
WATERMELON
* 출력
NALNBQEWTANRTZEZTKKOWQWUGW
*/

public class 소프티어_플레이페어_암호 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        String str = bf.readLine();     // 암호화할 문자열
        String key = bf.readLine();     // 암호화시키는 문자열
        char ch[][] = new char[5][5];   // 암호화 문자배열
        ArrayList<Character> abc = new ArrayList<>();   // 알파벳 리스트

        // 알파벳 리스트
        for(int i = 0; i < 26; i++) {   // 알바벳 개수만큼
            if('A' + i == 'J')  // J 는 배열크기때문에 스킵
                continue;
            abc.add((char)('A' + i));   // 리스트에 알파벳 추가
        }

        // 암호 배열
        int r = 0, c = 0;   // 문자배열 인덱스
        for(int i = 0; i < key.length(); i++) { // 암호 문자열 길이만큼
            if(abc.contains(key.charAt(i))) {   // 리스트에 포함되어있으면
                ch[r][c] = key.charAt(i);   // 해당 알파벳 암호배열에 저장
                abc.remove(Character.valueOf(ch[r][c]));    // 리스트에서 삭제

                c++;    // 열 인덱스
                if(c == 5) {    // 다음 열 이동
                    c = 0;
                    r++;
                }
            }
        }

        // 나머지 알파벳 리스트에 있는 값 넣기
        for(int i = 0; i < abc.size(); i++) {   // 리스트 크기만큼
            ch[r][c] = abc.get(i);  // 하나씩 꺼내어 암호배열에 저장

            c++;
            if(c == 5) {
                c = 0;
                r++;
            }
        }

        // 문자열 변경
        StringBuilder sb = new StringBuilder();
        sb.append(str); // 추가
        int index = 0;  // 문자열 인덱스
        while(index < sb.length() - 1) {    // 인덱스 0 부터 시작이므로 N - 1 개
            if(sb.charAt(index) == sb.charAt(index + 1)) {  // 두 글자 쌍이 같으면
                if(sb.charAt(index) == 'X') // X 인 경우
                    sb.insert(index + 1, 'Q');  // 사이에 Q 삽입
                else    // X 가 아닌 경우
                    sb.insert(index + 1, 'X');  // 사이에 X 삽입
            }

            index += 2; // 두 글자씩이므로 + 2
        }

        if(sb.length() % 2 == 1)    // 홀수인 경우 하나 남으므로
            sb.append('X'); // 뒤에 X 추가

        index = 0;
        while(index < sb.length() - 1) {
            char c1 = sb.charAt(index); // 문자 1
            char c2 = sb.charAt(index + 1); // 문자 2
            int x1 = 0, y1 = 0, x2 = 0, y2 = 0;

            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    if(c1 == ch[i][j]) {
                        x1 = i; // 문자 1의 x, y 좌표
                        y1 = j;
                    }

                    if(c2 == ch[i][j]) {
                        x2 = i; // 문자 2의 x, y 좌표
                        y2 = j;
                    }
                }
            }

            if(x1 == x2) {  // 같은 행인 경우 => 열 한 칸씩 이동
                if(y1 + 1 == 5) // 열 이동 시 넘어가는 경우
                    y1 = -1;    // 처음 인덱스로

                if(y2 + 1 == 5)
                    y2 = -1;

                sb.setCharAt(index, ch[x1][y1 + 1]);   // 문자 암호화
                sb.setCharAt(index + 1, ch[x2][y2 + 1]);
                index += 2; // 두 글자씩

                continue;   // 행, 열, 전부 다른 경우
                            //  3가지 경우가 있으므로 하나씩만 거치도록
            }

            if(y1 == y2) {  // 같은 열인 경우 => 행 한 칸씩 이동
                if(x1 + 1 == 5) // 행 이동 시 넘어가는 경우
                    x1 = -1;

                if(x2 + 1 == 5)
                    x2 = -1;

                sb.setCharAt(index, ch[x1 + 1][y1]);
                sb.setCharAt(index + 1, ch[x2 + 1][y2]);
                index += 2;

                continue;
            }

            // 전부 다 다른 경우 => 다른 글자의 열로 이동
            sb.setCharAt(index, ch[x1][y2]);
            sb.setCharAt(index + 1, ch[x2][y1]);
            index += 2;
        }

        System.out.println(sb); // 암호화된 문자열 출력
    }
}