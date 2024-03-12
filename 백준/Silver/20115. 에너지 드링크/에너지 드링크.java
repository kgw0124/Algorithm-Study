import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /* (1) 변수 입력 받기 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Double[] arr = new Double[N];
        for(int i=0; i<N; i++){
            arr[i] = Double.parseDouble(st.nextToken());
        }

        /* (2) 배열 내림차순 정렬 */
        Arrays.sort(arr, Collections.reverseOrder());

        /* (3) [그리디 알고리즘] 임의의 두 수를 대소비교 수행 후, 더 작은 값을 /2해서 더하자. */
        Double result = arr[0];
        for(int i=1; i<N; i++){
            result += arr[i]/2;
        }

        System.out.println(result);
    }
}