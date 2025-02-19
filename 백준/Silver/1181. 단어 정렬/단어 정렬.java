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
        Set<String> set = new HashSet<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            set.add(st.nextToken());
        }

        // 3.
        List<String> list = new ArrayList<>(set);

        // 3.
        Collections.sort(list, (o1, o2) -> {
            if(o1.length() == o2.length()){
                return o1.compareTo(o2);
            }else{
                Integer o1l = o1.length();
                Integer o2l = o2.length();
                return o1l.compareTo(o2l);
            }
        });

        // 4.
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}