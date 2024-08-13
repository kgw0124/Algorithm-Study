import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            // 1.
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> arr = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            
            for(int i=0; i<3; i++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 0){ // 1-1. 종료 판단
                    return;
                }
                arr.add(temp);
                set.add(temp);
            }

            // 2. 삼각형 조건 판단
            Collections.sort(arr);
            if(arr.get(2) >= arr.get(0) + arr.get(1)){
                System.out.println("Invalid");
                continue;
            }

            // 3. 삼각형 종류 판단
            switch(set.size()){
                case 1:
                    System.out.println("Equilateral");
                    break;
                case 2:
                    System.out.println("Isosceles");
                    break;
                default: // 3
                    System.out.println("Scalene");
                    break;
            }
        }
    }
}