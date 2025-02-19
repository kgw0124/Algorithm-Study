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
        ArrayList<Integer[]> ages = new ArrayList<>();
        String[] names = new String[N+1];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            Integer age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            ages.add(new Integer[]{i, age});
            names[i] = name;
        }

        // 3.
        Collections.sort(ages, (age1, age2) -> {
                    if(age1[1] == age2[1]){
                        return age1[0].compareTo(age2[0]);
                    }else{
                        return age1[1].compareTo(age2[1]);
                    }
                }
            );

        // 4.
        for(int i=0; i<ages.size(); i++){
            System.out.println(ages.get(i)[1] + " " + names[ages.get(i)[0]]);
        }
    }
}