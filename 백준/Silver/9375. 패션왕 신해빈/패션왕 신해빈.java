import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testcase = Integer.parseInt(st.nextToken());

        StringBuilder answer = new StringBuilder();
        // 2.
        for(int t=0; t<testcase; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            // HashMap 생성
            HashMap<String, ArrayList<String>> map = new HashMap<>();
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                String value = st.nextToken();
                String key = st.nextToken();

                if (map.containsKey(key)){
                    map.get(key).add(value);
                }else {
                    ArrayList<String> tmp = new ArrayList<>();
                    tmp.add(value);
                    map.put(key, tmp);
                }
            }

            //
            int cnt = 1;
            for(String key: map.keySet()){
                cnt *= (map.get(key).size()+1); // +1 : 입지 않는 경우
            }
            answer.append(cnt-1).append("\n"); // -1 : 모두 입지 않는 경우
        }
        System.out.println(answer);
    }
}