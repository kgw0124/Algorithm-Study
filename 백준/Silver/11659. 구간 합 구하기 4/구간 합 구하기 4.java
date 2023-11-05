import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Integer N;
        Integer M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> sum = new ArrayList<>();
        sum.add(0); // sum[0] = 0으로 초기화

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            if(i==0){
                sum.add(Integer.parseInt(st2.nextToken()));
            }else{
                Integer pastValue = sum.get(i);
                Integer newValue = pastValue + Integer.parseInt(st2.nextToken()); // sum[i] = sum[i-1] + A[i]
                sum.add(newValue);
            }
        }

        ArrayList<Integer> results = new ArrayList<>();
        for(int i=0; i<M; i++){
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            Integer start = Integer.parseInt(st3.nextToken());
            Integer end = Integer.parseInt(st3.nextToken());

            Integer sumToStart = sum.get(start-1); // sum[start-1]
            Integer sumToEnd = sum.get(end); // sum[end]
            Integer result = sumToEnd - sumToStart; // sum[end] - sum[start]
            results.add(result);
        }

        for(int i=0; i<results.size(); i++){
            System.out.println(results.get(i));
        }
    }
}