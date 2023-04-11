import java.io.*;
import java.util.*;

public class 큰수식찾기_구름Level {
    public static void main(String[] args) throws Exception {
        List<Long> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] str = input.split(" ");

        for(int i = 0; i < 2; i++) {
            List<Long> nums = new ArrayList<>();
            List<Character> op = new ArrayList<>();
            String num = "";

            for(int j = 0; j < str[i].length(); j++) {
                char c = str[i].charAt(j);

                if(c >= '0' && c <= '9') {
                    num += c;
                } else {
                    nums.add(Long.parseLong(num));
                    op.add(c);
                    num = "";
                }
            }

            nums.add(Long.parseLong(num));
            long sum = 0;
            for(int k = 0; k < op.size(); k++) {
                if(op.get(k) == '*') {
                    sum = calcNum(nums.remove(k), nums.remove(k), op.remove(k));
                    nums.add(k--, sum);
                }
            }

            for(int k = 0; k < op.size(); k++) {
                sum = calcNum(nums.remove(k), nums.remove(k), op.remove(k));
                nums.add(k--, sum);
            }

            list.add(nums.get(0));
        }

        long a = list.get(0);
        long b = list.get(1);

        if(a > b)
            System.out.print(a);
        else
            System.out.print(b);
    }

    public static long calcNum(long a, long b, char c) {
        switch(c) {
            case '*' :
                return a * b;
            case '+' :
                return a + b;
            default :
                return a - b;
        }
    }
}