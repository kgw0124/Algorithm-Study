import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        /** (1) 정렬할 숫자의 개수 입력 받기 및 개수만큼 크기를 가지는 배열 생성 **/
        int count = Integer.parseInt(br.readLine());
        mData[] numbs = new mData[count];

        /** (2) count만큼 반복하여 배열에 내용 채우기 : 원본 배열 생성 **/
        for(int i=0; i<count; i++){
            numbs[i] = new mData(Integer.parseInt(br.readLine()), i);
        }

        /** (3) 정렬 배열 생성 **/
        Arrays.sort(numbs);

        /** (4) 정렬 전/후 동일한 원소에 대한 인덱스 비교 **/
        int diff = 0;
        for(int i=0; i<count; i++){ // i는 정렬 후 인덱스, numbs[i].index는 정렬 전 인덱스
            if(numbs[i].index - i >diff){
                diff=numbs[i].index - i;
            }
        }

        System.out.println(diff + 1);
    }
}

class mData implements Comparable<mData>{
    int value;
    int index;

    public mData(int value, int index){
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(mData o){
        return this.value - o.value;
    }
}