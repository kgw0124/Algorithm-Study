import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n == 0){ // 런타임 에러 해결
            System.out.println(0);
            return;
        }else if(n == 1){
            System.out.println(1);
            return;
        }

        // DP 결과를 누적할 배열 생성
        result = new int[n+1];
        result[0] = 0;
        result[1] = 1;

        for(int i=2; i<=n; i++){
            result[i] = result[i-1] + result[i-2]; // DP
        }

        System.out.println(result[n]);
    }
}