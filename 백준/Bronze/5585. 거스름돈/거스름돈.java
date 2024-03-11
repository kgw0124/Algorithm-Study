import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /* (1) 변수 입력 받기 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());

        /* (2) 잔돈 계산 */
        int changes = 1000 - money;

        /* (3) [그리디 알고리즘] 최소한의 동전 개수로 잔돈 거슬러주기 */
        int[] coins = new int[]{500, 100, 50, 10, 5, 1};
        int count = 0;
        for(int coin : coins){
            count += changes / coin;
            changes %= coin;
        }
        System.out.println(count);
    }
}