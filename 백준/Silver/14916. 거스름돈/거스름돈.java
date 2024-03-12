import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /* (1) 변수 입력 받기 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = -1; // (1) default값 : 경우의 수가 없다고 가정

        if(N%5 == 0){ // (2) 5원으로만 사용
            result = N/5;
        }else{
            int max5 = N/5;
            for(int i=max5; i>=0; i--){
                int changes = N - 5*i;
                if(changes%2 == 0){ // (3) 2원과 5원을 모두 사용
                    result = i + changes/2;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}