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
        int[] answers = new int[N+1];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            
            ArrayList<Integer> students = new ArrayList<>();
            int answer = 0;
            int answerIdx = Integer.parseInt(st.nextToken());

            for(int j=0; j<20; j++){
                // 2-1 1st 학생
                int student = Integer.parseInt(st.nextToken());
                students.add(student);

                // 2-2. 2nd 학생~
                for(int s: students){
                    if(s > student){
                        answer++;
                    }
                }
            }
            answers[answerIdx] = answer;
        }

        // 3.
        for(int i=1; i<answers.length; i++){
            System.out.println(i + " " + answers[i]);
        }
    }
}