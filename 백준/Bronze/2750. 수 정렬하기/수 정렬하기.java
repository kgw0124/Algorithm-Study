import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        /** (1) 정렬할 숫자의 개수 입력 받기 및 개수만큼 크기를 가지는 배열 생성 **/
        int count = Integer.parseInt(br.readLine());
        int[] numbs = new int[count];

        /** (2) count만큼 반복하여 배열에 내용 채우기 **/
        for(int i=0; i<count; i++){
            numbs[i] = Integer.parseInt(br.readLine());
        }

        /** (3) 버블 정렬 수행 **/
        for(int i=0; i<count-1; i++){ //i를 마지막 인덱스까지 순회하면 마지막 인덱스와 그 다음 인덱스를 비교하기 때문에 오류 발생
            for(int j=0; j<count-1-i; j++){ //j가 인접한 2개의 인덱스를 비교할 때, 첫번째 인덱스 역할 수행
                if(numbs[j] > numbs[j+1]){
                    int temp = numbs[j];
                    numbs[j] = numbs[j+1];
                    numbs[j+1] = temp;
                }
            }
        }

        /** (4) 결과 출력 **/
        for(int i=0; i<count; i++){
            System.out.println(numbs[i]);
        }

    }
}