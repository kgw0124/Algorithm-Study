import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // N, M, numbs(재료들의 고유 번호)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        Integer[] numbs = new Integer[N+1];
        numbs[0] = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            numbs[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbs); // ** 오름차순으로 정렬 **

        // ** 고유한 값들의 모음이기 때문에 중복값은 고려하지 않음 **
        int start = 1;
        int end = 2; // 중복 고려하지 않기 때문에, start와 end는 1씩 차이를 가진다.
        int count = 0;

        while(start != N){
            if(numbs[start] + numbs[N] < M){ // start 인덱스의 값과 마지막 인덱스의 값을 더했을 때, M보다 작으면 해당 start 인덱스는 넘긴다.
                start++;
                end = start + 1;
            }else {
                int sum = numbs[start] + numbs[end];
                if(sum == M){
                    count++;
                    start++;
                    end = start + 1; // 중복 고려하지 않기 때문에, start와 end는 1씩 차이를 가진다.
                }else if(sum < M){
                    if(end == N){
                        start++;
                        end = start + 1; // 중복 고려하지 않기 때문에, start와 end는 1씩 차이를 가진다.
                    }
                    end++;
                }else if(sum > M){
                    start++;
                    end = start + 1; // 중복 고려하지 않기 때문에, start와 end는 1씩 차이를 가진다.
                }
            }
        }

        System.out.println(count);
    }
}
