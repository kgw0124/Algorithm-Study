import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int n = Integer.parseInt(br.readLine());

         dp = new int[1001];
         dp[1] = 1;
         dp[2] = 2; // n이 1일 경우, 여기서 오류 발생 -> dp 크기 최대값으로 범위 고정해주기

         for(int i=3; i<n+1; i++){
             dp[i] = (dp[i-1] + dp[i-2]) % 10007; // 10007로 나눈 나머지로 채워지도록 할 것
         }

         System.out.println(dp[n]); // 마지막에 계산하면 틀림
    }
}