import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 슬라이딩_윈도우_009 {
    static int checkSum; // 정답배열과 현재배열 체크
    static int myArr[]; // 현재배열
    static int checkArr[]; // 정답배열

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        int S = Integer.parseInt(st.nextToken()); // 총 문자열 길이
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열 길이

        char ch[] = new char[S]; // 비교할 부분 문자배열
        ch = bf.readLine().toCharArray(); // 문자열 -> 문자배열
        checkArr = new int[4]; // 정답배열 초기화
        myArr = new int[4]; // 현재
        checkSum = 0;
        int res = 0;

        st = new StringTokenizer(bf.readLine()); // 한 줄 스트링
        for (int i = 0; i < 4; i++) { // 총 4개 A C G T
            checkArr[i] = Integer.parseInt(st.nextToken()); // 정답배열
            if (checkArr[i] == 0) { // 0 이면
                checkSum++; // 해당 문자 비교할 필요 X => 1개 증가
            }
        }

        for (int i = 0; i < P; i++) { // 처음 슬라이딩 윈도우 (0 ~ 부분 문자열 길이)
            Add(ch[i]); // 추가하여 비교
        }

        if (checkSum == 4) { // 정답배열과 같으면
            res++; // 결과값 1 증가시킴
        }

        for (int i = P; i < S; i++) { // 다음 슬라이딩 윈도우 1개씩 비교 (부분 ~ 전체)
            int j = i - P; // 제거할 인덱스
            Add(ch[i]); // 추가
            Remove(ch[j]); // 삭제
            if (checkSum == 4) { // 비교
                res++;
            }
        }

        System.out.println(res); // 결과값 출력
    }

    private static void Add(char c) { // 추가
        switch (c) { // 문자 비교
            case 'A':
                myArr[0]++; // 현재배열에서 해당 문자 인덱스 값 증가
                if (myArr[0] == checkArr[0]) // 같은 지 비교
                    checkSum++; // 같으면 비교값 1 증가
                break;

            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1])
                    checkSum++;
                break;

            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2])
                    checkSum++;
                break;

            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3])
                    checkSum++;
                break;
        }
    }

    private static void Remove(char c) { // 삭제
        switch (c) { // 문자 비교
            case 'A':
                if (myArr[0] == checkArr[0]) // 이 전에 같았으면
                    checkSum--; // 이제는 다르므로 비교값 1 감소
                myArr[0]--; // 현재배열에서 해당 문자 인덱스 값 감소
                break;

            case 'C':
                if (myArr[1] == checkArr[1])
                    checkSum--;
                myArr[1]--;
                break;

            case 'G':
                if (myArr[2] == checkArr[2])
                    checkSum--;
                myArr[2]--;
                break;

            case 'T':
                if (myArr[3] == checkArr[3])
                    checkSum--;
                myArr[3]--;
                break;
        }
    }
}
