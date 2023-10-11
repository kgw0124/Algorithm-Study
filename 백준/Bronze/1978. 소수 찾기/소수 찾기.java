import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /** 변수 **/
        Integer N;
        Integer count = 0;

        /** 사용자에게 입력 받기 **/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());

        /** 소수 개수 세기 **/
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            Integer temp = Integer.parseInt(st.nextToken());
            if(isPrime(temp)){
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean isPrime(Integer X){
        if(X==1){
            return false;
        }
        for(int i=2; i*i<=X; i++){
            if(X % i == 0){
                return false; //나누어떨어지는 수가 있는 순간, X는 소수가 아니다.
            }
        }
        return true;
    }
}