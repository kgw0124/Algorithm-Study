import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(Integer.parseInt(st.nextToken()), i);
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        // 2.
        int answer = 0;
        for(int k: map.keySet()){
            int diff = m - k;
            if (k < diff){
                if(map.containsKey(diff)){
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }
}