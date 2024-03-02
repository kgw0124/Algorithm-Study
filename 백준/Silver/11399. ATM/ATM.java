import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /** (1) 정렬 대상 개수 입력 받기 **/
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int count = Integer.parseInt(br.readLine());

        /** (2) 대상을 정렬하여 저장할 배열 생성 */
        int arr[] = new int[count];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int index=0;
        while(st.hasMoreTokens()){
            arr[index] = Integer.parseInt(st.nextToken());
            index++;
        }

        /** (3) 삽입 정렬 수행 **/
        for(int i=1; i<count; i++){
            int insertIndex = i;
            for(int j=i-1; j>=0; j--){
                int insertValue = arr[insertIndex];
                if(insertValue < arr[j]){
                    arr[insertIndex] = arr[j];
                    arr[j] = insertValue;
                    insertIndex = j;
                }
            }
        }

        /** (3) 순서에 따른 누적 대기 시간 계산 **/
        int total = 0;
        int temp = 0;
        for(int i=0; i<count; i++){
            temp += arr[i];
            total += temp;
        }
        System.out.println(total);
    }
}