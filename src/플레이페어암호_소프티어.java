import java.io.*;
import java.util.*;


public class 플레이페어암호_소프티어 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = bf.readLine();
        String key = bf.readLine();
        char ch[][] = new char[5][5];
        ArrayList<Character> abc = new ArrayList<>();

        for(int i = 0; i < 26; i++) {
            if('A' + i == 'J')
                continue;
            abc.add((char)('A' + i));
        }

        int r = 0, c = 0;
        for(int i = 0; i < key.length(); i++) {
            if(abc.contains(key.charAt(i))) {
                ch[r][c] = key.charAt(i);
                abc.remove(Character.valueOf(ch[r][c]));

                c++;
                if(c == 5) {
                    c = 0;
                    r++;
                }
            }
        }

        for(int i = 0; i < abc.size(); i++) {
            ch[r][c] = abc.get(i);

            c++;
            if(c == 5) {
                c = 0;
                r++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(str);
        int index = 0;
        while(index < sb.length() - 1) {
            if(sb.charAt(index) == sb.charAt(index + 1)) {
                if(sb.charAt(index) == 'X')
                    sb.insert(index + 1, 'Q');
                else
                    sb.insert(index + 1, 'X');
            }

            index += 2;
        }

        if(sb.length() % 2 == 1)
            sb.append('X');

        index = 0;
        while(index < sb.length() - 1) {
            char c1 = sb.charAt(index);
            char c2 = sb.charAt(index + 1);
            int x1 = 0, y1 = 0, x2 = 0, y2 = 0;

            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    if(c1 == ch[i][j]) {
                        x1 = i;
                        y1 = j;
                    }

                    if(c2 == ch[i][j]) {
                        x2 = i;
                        y2 = j;
                    }
                }
            }

            if(x1 == x2) {
                if(y1 + 1 == 5)
                    y1 = -1;

                if(y2 + 1 == 5)
                    y2 = -1;

                sb.setCharAt(index, ch[x1][y1 + 1]);
                sb.setCharAt(index + 1, ch[x2][y2 + 1]);
                index += 2;

                continue;
            }

            if(y1 == y2) {
                if(x1 + 1 == 5)
                    x1 = -1;

                if(x2 + 1 == 5)
                    x2 = -1;

                sb.setCharAt(index, ch[x1 + 1][y1]);
                sb.setCharAt(index + 1, ch[x2 + 1][y2]);
                index += 2;

                continue;
            }

            sb.setCharAt(index, ch[x1][y2]);
            sb.setCharAt(index + 1, ch[x2][y1]);
            index += 2;
        }

        System.out.println(sb);
    }
}