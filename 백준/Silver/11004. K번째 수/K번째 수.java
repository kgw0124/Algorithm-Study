import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void quickSort(int[] arr, int start, int end, int findIndex){
        int pivotIndex = partition(arr, start, end);

        if(pivotIndex == findIndex){
            return;
        }else if(findIndex < pivotIndex){
            quickSort(arr, start, pivotIndex-1, findIndex);
        }else if(pivotIndex < findIndex){
            quickSort(arr, pivotIndex + 1, end, findIndex);
        }
    }

    public static int partition(int[] arr, int start, int pivotIndex){
        int pivotValue = arr[pivotIndex]; // pivot을 partition의 가장 마지막 인덱스로 설정

        int low = start;
        int high = pivotIndex - 1; // pivotIndex(= 마지막 index) 바로 앞

        while(low <= high){ // 전제 조건
            /** (pivotIndex 앞에 값이 1개만 존재하는 경우) pivot과 해당 값을 바로 비교 **/
            if(low == high){
                if(arr[low] > arr[pivotIndex]){
                    swap(arr, low, pivotIndex);
                    return low;
                }
            }

            /** (1) low가 pivotValue보다 큰 값을 최초로 가리킬 때까지 low를 오른쪽으로 이동 **/
            while(arr[low] < pivotValue && low < pivotIndex){ low++; }

            /** (2) high가 pivotValue보다 작은 값을 최초로 가리킬 때까지 high를 왼쪽으로 이동 **/
            while(arr[high] > pivotValue && 0 < high){ high--; }

            /** (3) 현재 low는 pivotValue보다 큰 값을, high는 pivotValue보다 작은 값을 가리키고 있기 때문에 low와 high가 가리키는 값을 바꿔 해결한다. **/
            if(low < high){
                swap(arr, low, high);
                low++;
                high--;
            }
        }

        /** (4) pivot을 적절한 위치로 이동시키기 **/
        swap(arr, low, pivotIndex);

        return low;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) throws IOException {
        /** (1) 정렬 대상 개수 및 값을 얻고자 하는 인덱스 입력 받기 **/
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()) -1; //인덱스는 0부터 시작하니깐

        /** (2) 입력 받은 값으로 배열 채우기 **/
        int[] arr = new int[count];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<count; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //Arrays.sort(arr); // 시간 복잡도 : O(nlogn)

        /** (3) 퀵 정렬 수행 **/
        quickSort(arr, 0, count-1, k);

        /** (4) 답 출력 **/
        System.out.println(arr[k]);
    }
}
