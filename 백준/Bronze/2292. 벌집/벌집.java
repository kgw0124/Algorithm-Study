import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        // 2.
        int idx = 2;
        int temp = 2;
        while(temp <= N){
            temp = temp + 6*(idx-1);
            idx++;
        }
        System.out.println(idx-1);
    }
}