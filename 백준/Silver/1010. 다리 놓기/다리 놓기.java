import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if(N == M){
                sb.append(1).append("\n");
                continue;
            }

            dp = new int[M+1][M+1]; // 시간 초과 문제 해결
            sb.append(combination(M, N)).append("\n");
        }

        System.out.print(sb);
    }

    public static int combination(int n, int r){
        if(n==r || r==0){
            return dp[n][r] = 1;
        }else if(dp[n][r] > 0){
            return dp[n][r];
        }else{
            return dp[n][r] = combination(n-1, r-1) + combination(n-1, r);
        }
    }
}