import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 변수 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int value = Integer.parseInt(st.nextToken());
            nums[i] = value;
        }

        // 2. dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
        int[] dp = new int[n];
        dp[0] = nums[0]; // 초기화
        int max = nums[0]; // nums 속 모든 원소가 음수인 경우 대응
        for(int i=1; i<n; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            max = Math.max(max, dp[i]);
        }

        // 3.
        System.out.println(max);
    }
}