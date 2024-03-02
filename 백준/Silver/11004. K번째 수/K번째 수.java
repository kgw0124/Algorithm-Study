import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /** (1) 정렬 대상 개수 및 값을 얻고자 하는 인덱스 입력 받기 **/
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int index = Integer.parseInt(st.nextToken()) -1; //인덱스는 0부터 시작하니깐

        /** (2) 입력 받은 값으로 배열 채우기 및 정렬 수행 **/
        int[] arr = new int[count];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<count; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 시간 복잡도 : O(nlogn)

        /** (3) 답 출력 **/
        System.out.println(arr[index]);
    }
}