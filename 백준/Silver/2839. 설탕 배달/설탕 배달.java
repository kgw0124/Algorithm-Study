import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Integer N;
        boolean isResult = false;
        Integer result;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=N/5; i>=0; i--){
            Integer less = N - (5 * i);
            if(less % 3 == 0){
                isResult = true;
                result = i + (less / 3);
                System.out.println(result);
                break;
            }
        }

        if(!isResult){
            System.out.println(-1);
        }
    }
}