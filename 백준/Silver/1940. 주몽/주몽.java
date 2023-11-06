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
        numbs[0] = 0; // numbs[0] 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            numbs[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbs); // ** 오름차순으로 정렬 **

        // ** 고유한 값들의 모음이기 때문에 중복값은 고려하지 않음 **
        int start = 1;
        int end = N;
        int count = 0;

        while(start < end){
            if(numbs[start] + numbs[end] == M){
                count++;
                start++;
                end--;
            }else if(numbs[start] + numbs[end] < M){
                start++;
            }else if(numbs[start] + numbs[end] > M){
                end--;
            }
        }

        System.out.println(count);
    }
}