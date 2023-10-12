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

        /** 1부터 N 사이의 수를 저장할 배열 생성 및 초기화 **/
        /*
         크기가 N+1인 이유? 
         배열의 인덱스는 0부터 시작한다. 즉, 배열의 크기가 N이라면 인덱스는 0 ~ N-1까지 존재한다.
         그런데, 우리는 1~N을 원하므로 크기를 N+1하여 배열이 인덱스를 0~N까지 가질 수 있도록 한다.
         */
        boolean[] numbs = new boolean[N+1];
        numbs[0]= false; // 숫자 0은 소수 판별에서 제외
        numbs[1]= false; // 숫자 1은 소수 판별에서 제외
        for(int i=2; i<=N; i++){ // 2부터 N까지 모든 수를 소수라고 가정
            numbs[i]=true;
        }

        /** 소수 판별 **/
        for(int i=2; i<=Math.sqrt(N); i++){ //범위에서 마지막 수의 제곱근까지만 확인
            if(numbs[i]){
                for(int j=2; i*j<=N; j++){ //i가 소수라면, 마지막 수보다 작은 i의 배수 모두 false 처리
                    numbs[i*j] = false;
                }
            }
        }

        /** 범위 내 소수 출력 **/
        for(int i=M; i<=N; i++){
            if(numbs[i]){
                System.out.println(i);
            }
        }
    }
}