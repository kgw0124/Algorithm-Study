import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 2.
        int[] dp = new int[N+1];
        for(int i=1; i<=N; i++){
            dp[i] = 1;
            for(int j=1; j<i; j++){
                if(arr[j] < arr[i] && dp[i] < dp[j] + 1){ // dp[i] < dp[j] + 1 <- 중요
                    dp[i] = dp[j] + 1;
                }
            }
        }

        // 3.
        Arrays.sort(dp);
        System.out.println(dp[N]);
    }
}