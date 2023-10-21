import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 테스트 케이스 개수 입력 받기
        Integer N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 테스트 케이스 입력 받기
        Integer[] results = new Integer[N];
        for(int i=0; i<N; i++) {
            int[] dp = new int[11]; //정수 n의 범위가 1~10이기 때문에, 인덱스도 10까지 생기도록 크기를 11로 설정
            //단위값 설정
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            //발견한 dp 규칙 적용 : dp[n] = dp[n-1] + dp[n-2] + dp[n-3]
            Integer testCase = Integer.parseInt(br.readLine());
            for (int j = 4; j <= testCase; j++) {
                dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
            }
            //결과 저장
            results[i] = dp[testCase];
        }
        
        //결과 출력
        for(int i=0; i<results.length; i++){
            System.out.println(results[i]);
        }
    }
}