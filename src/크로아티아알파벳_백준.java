import java.util.*;
import java.io.*;

/*
ljes=njak
 */

public class 크로아티아알파벳_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        String word = bf.readLine();    // 한 줄 스트링

        String[] str = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};   // 크로아티아 알파벳

        for(String s : str) // 개수만큼
            word = word.replaceAll(s, "a"); // 문자 치환

        System.out.println(word.length());  // 길이 출력
    }
}
