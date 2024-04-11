import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[N+1][N+1];
        System.out.println(combination(N,K));
    }
    
    public static int combination(int n, int r){
        if(n==r || r==0){
            return dp[n][r] = 1;
        }else if(dp[n][r] > 0){ // 계산 이력이 있는 nCr인 경우
            return dp[n][r];
        }else{ // nCr의 점화식 : nCr = n-1Cr-1 + n-1Cr
            return dp[n][r] =combination(n-1, r-1) + combination(n-1, r);
        }
    }
}