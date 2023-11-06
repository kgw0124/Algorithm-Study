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

        Integer[] numbs = new Integer[N+1]; // 고유한 값들이기 때문에 중복 고려하지 않음
        numbs[0] = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            numbs[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbs); // 오름차순으로 정렬

        // 탐색 시작 ** 고유한 값들의 모음이기 때문에 중복값은 고려하지 않음 **
        int start = 1;
        int end = 2;
        int count = 0;

        while(start != N){
            if(numbs[start] + numbs[N] < M){
                start++;
                end = start + 1;
            }else {
                int sum = numbs[start] + numbs[end];
                if(sum == M){
                    count++;
                    start++;
                    end = start + 1;
                }else if(sum < M){
                    if(end == N){
                        start++;
                        end = start + 1;
                    }
                    end++;
                }else if(sum > M){
                    start++;
                    end = start + 1;
                }
            }
        }

        System.out.println(count);
    }
}