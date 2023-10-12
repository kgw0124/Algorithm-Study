import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /** 변수 **/
        Integer M;
        Integer N;

        /** 사용자에게 입력 받기 **/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for(int i=M; i<=N; i++){
            if(isPrime(i)){
                System.out.println(i);
            }
        }

    }

    public static boolean isPrime(Integer X){
        if(X==1){
            return false; //X가 1인지 확인
        }
        for(int i=2; i<=Math.sqrt(X); i++){
            if(X % i == 0){
                return false; //나누어떨어지는 수가 있는 순간, X는 소수가 아니다.
            }
        }
        return true;
    }
}