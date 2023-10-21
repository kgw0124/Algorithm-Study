import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        /** 점진적으로 생기는 결과값을 저장할 ArrayList 생성 */
        ArrayList<Integer> dp = new ArrayList<>();
        /**  초기값 설정 */
        dp.add(0); //dp[0] = 0
        dp.add(0); //dp[1] = 0

        /** 정수 N 받기 **/
        Integer N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        /** dp 수행 **/
        for(int i=2; i<=N; i++){
            ArrayList<Integer> past = new ArrayList<>();
            if(i%3==0){
                past.add(dp.get(i/3));
            }
            if(i%2==0){
                past.add(dp.get(i/2));
            }
            past.add(dp.get(i-1));
            Integer min = Collections.min(past);
            /** past를 구하기 위해 수행한 연산을 포함하기 위해 1을 더함 **/
            dp.add(min+1);
        }

        // 출력
        System.out.println(dp.get(N));
    }
}