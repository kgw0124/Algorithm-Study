import java.util.*;

class Solution {
    public String solution(String new_id) {
        // 1단계. 
        String after1 = new_id.toLowerCase();
        
        // 2단계.
        String after2 = after1.replaceAll("[^a-z0-9\\-\\_\\.]", "");
        
        // 3단계. 
        String after3 = after2.replaceAll("\\.+", ".");
        
        // 4단계.
        String after4 = after3.replaceAll("^\\.", "").replaceAll("\\.$", "");
    
        // 5단계.
        String after5 = after4.equals("") ? "a" : after4;
        
        // 6단계.
        String after6 =  after5;
        if(after6.length() > 15){
            after6 = after6.substring(0, 15).replaceAll("\\.$", "");
        }
        
        // 7단계.
        String after7 = after6;
        while(after7.length() < 3){
            after7 += after7.charAt(after7.length()-1);
        }        
        
        String answer = after7;
        return answer;
    }
}