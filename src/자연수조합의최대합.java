public class 자연수조합의최대합 {
    public static void main(String[] args) {
        int[] arr = new int[] {6, 6, 9, 2, 4, 7};

        int answer = 0;
        for(int i = 0; i < arr.length - 3; i++) {
            for(int j = i + 1; j < arr.length - 2; j++) {
                for (int k = j + 1; k < arr.length - 1; k++) {
                    for(int t = k + 1; t < arr.length; t++) {
                        int sum = arr[i] + arr[j] + arr[k] + arr[t];

                        if (t - i == 3)
                            sum += 5;
                        else if (k - i == 2 || t - j == 2)
                            sum += 3;
                        else if (j - i == 1 || k - j == 1 || t - k == 1)
                            sum += 2;

                        if(answer < sum)
                            answer = sum;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
