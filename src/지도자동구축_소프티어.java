import java.util.*;

public class 지도자동구축_소프티어 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] D = new int[16];

        D[0] = 2; D[1] = 3;
        for(int i = 2; i < 16; i++)
            D[i] = 2 * D[i - 1] - 1;

        System.out.println(D[N] * D[N]);
    }
}
