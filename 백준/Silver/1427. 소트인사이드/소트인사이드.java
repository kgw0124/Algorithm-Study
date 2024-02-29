import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /** (1) 정렬 대상 입력 받기 **/
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        char[] numbs = br.readLine().toCharArray();

        /** (2) 선택 정렬 수행 **/
        for(int i=0; i<numbs.length-1; i++){ // swap 대상 중 첫번째 대상
            int maxIndex = i+1;
            char max = numbs[maxIndex];
            for(int j=maxIndex+1; j<numbs.length; j++){ // swap 대상 중 두번째 대상 : i 인덱스 제외 나머지 인덱스들 중 가장 큰 원소 탐색
                if(numbs[j] > max){ // char의 비교 : ASCII 비교 : Integer.parseInt() 안해도 된다.
                    maxIndex= j;
                    max = numbs[j];
                }
            }

            if(max > numbs[i]){ // swap
                char temp = max;
                numbs[maxIndex] = numbs[i];
                numbs[i] = temp;
            }
        }

        /** (3) 답 출력 **/
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numbs.length; i++){
            sb.append(numbs[i]);
        }
        System.out.println(sb);
    }
}