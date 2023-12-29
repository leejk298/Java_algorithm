import java.util.*;
import java.io.*;

/*
3 14
 */

public class 요일출력_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int m = Integer.parseInt(st.nextToken());   // 달
        int d = Integer.parseInt(st.nextToken());   // 일

        String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};  // 요일
        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // 일 수

        int sum = 0;    // 총 일
        for (int i = 0; i < m; i++) // 달 수
            sum += months[i];   // 총 합

        sum += d - 1;   // 일 수

        System.out.println(days[sum % 7]);  // 요일 출력
    }
}
