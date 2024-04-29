import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // (1) 값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // (2) DP 수행 : DP[n] = DP[n-1] + DP[n-2]*2
        int[] DP = new int[1001];
        DP[1] = 1;
        DP[2] = 3;
        for(int i=3; i<=n; i++){
            DP[i] = (DP[i-1] + DP[i-2]*2) % 10007;
        }

        // (3) 정답 출력
        System.out.println(DP[n]);
    }
}