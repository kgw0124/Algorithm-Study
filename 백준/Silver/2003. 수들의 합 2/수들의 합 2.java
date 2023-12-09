import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수의 개수
        int M = Integer.parseInt(st.nextToken()); // 총합

        int[] numbs = new int[N]; // 수를 담을 배열 생성
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            if(st.hasMoreTokens()){
                numbs[i] = Integer.parseInt(st.nextToken());
            }
        }

        int start = 0;
        int end = 1;
        int answer = 0;
        int sum = numbs[start];

        while(start < N){
            if(start == N - 1){ // 마지막 수만 따로 처리
                if(numbs[start] == M){
                    answer++;
                    break;
                }
                break;
            }

            if(sum == M){
                answer++;
                start++;
                end = start + 1;
                sum = numbs[start];
            }else if(sum > M){
                start++;
                end = start + 1;
                sum = numbs[start];
            }else if(sum < M){
                if(end >= N){ // 마지막 수까지 더했는 데도 sum이 M보다 작은 경우
                    start++;
                    end = start + 1;
                    sum = numbs[start];
                }else{
                    sum += numbs[end];
                    end++;
                }
            }
        }

        System.out.println(answer);
    }
}