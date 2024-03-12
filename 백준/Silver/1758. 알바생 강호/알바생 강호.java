import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        /* (1) 변수 입력 받기 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        /* (2) 배열 내림차순 정렬 */
        Arrays.sort(arr, Collections.reverseOrder());

        /* (3) 팁 총합 구하기 */
        long tip = 0;
        for(int i=0; i<N; i++){
            if(arr[i] - i < 0){ // 팁 계산 결과가 음수면 더하지 않는다.
                break;
            }
            tip += arr[i] - i;
        }

        System.out.println(tip);
    }
}