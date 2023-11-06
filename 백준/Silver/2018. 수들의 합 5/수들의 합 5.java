import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int start = 1;
        int end = 1;
        int sum = 1;
        int count = 1; // 자기 자신인 경우 포함

        while(start != N){
            if(sum < N){
                end++;
                sum = sum + end;
            }else if(sum > N){
                sum = sum - start;
                start++;
            }else{
                count++;
                end++;
                sum = sum + end;
            }
        }

        System.out.println(count);
    }
}