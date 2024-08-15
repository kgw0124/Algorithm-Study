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
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            switch(type){
                case "add":
                    set.add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove":
                    set.remove(Integer.parseInt(st.nextToken()));
                    break;
                case "check":
                    if(set.contains(Integer.parseInt(st.nextToken()))){
                        sb.append("1\n");
                    }else{
                        sb.append("0\n");
                    }
                    break;
                case "toggle":
                    int value = Integer.parseInt(st.nextToken());
                    if(set.contains(value)){
                        set.remove(value);
                    }else{
                        set.add(value);
                    }
                    break;
                case "all":
                    set = new HashSet<>();
                    for(int j=1; j<=20; j++){
                        set.add(j);
                    }
                    break;
                default: // empty
                    set = new HashSet<>();
                    break;
            }
        }
        System.out.println(sb);
        br.close();
    }
}