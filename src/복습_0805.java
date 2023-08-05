import java.util.*;
import java.io.*;

/*
leaf
Wednesday
5
First Wednesday of January
Second Saturday of June
Third Friday of October
Fourth Tuesday of March
Last Sunday of November
 */

public class 복습_0805 {
    static List<Integer>[][] A;
    static int[] date;
    static String[] week = {"First", "Second", "Third", "Fourth", "Last"};
    static String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    static String[] day = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    static Map<String, Integer> W, M, D;
    static int start, T;
    static StringBuilder sb;

    public static void init(BufferedReader bf) throws IOException {

        if(bf.readLine().equals("leaf"))
            date = new int[] {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        else
            date = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        W = new HashMap<>();
        M = new HashMap<>();
        D = new HashMap<>();

        for(int i = 0; i < week.length; i++)
            W.put(week[i], i);

        for(int i = 0; i < month.length; i++)
            M.put(month[i], i);

        for(int i = 0; i < day.length; i++)
            D.put(day[i], i);

        String str = bf.readLine();
        start = D.get(str);

        A = new List[12][7];    // 12개월, 7주일
        for(int i = 0; i < 12; i++)
            for(int j = 0; j < 7; j++)
                A[i][j] = new ArrayList<>();

        for(int i = 0; i < 12; i++) {
            int diff = start - 1;
            int end = date[i];

            for(int j = start; j <= start + end; j++) {
                int num = j - diff;
                A[i][j % 7].add(num);
            }

            start = (start + end + 1) % 7;
            if(start == 0)
                start = 7;
        }

        T = Integer.parseInt(bf.readLine());

        sb = new StringBuilder();
    }

    public static void printMonthAndDate(String s) {

        String[] st = s.split(" ");

        int weeks = W.get(st[0]);
        int days = D.get(st[1]);
        int months = M.get(st[3]);

        if(weeks == 4)
           sb.append(months + 1 + " " + A[months][days].get(A[months][days].size() - 1) + "\n");
        else
            sb.append(months + 1 + " " + A[months][days].get(weeks) + "\n");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        init(bf);

        while (T-- > 0)
            printMonthAndDate(bf.readLine());

        System.out.print(sb);
    }
}
