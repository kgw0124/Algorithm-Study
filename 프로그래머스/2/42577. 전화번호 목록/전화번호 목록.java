import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<phone_book.length; i++){
            map.put(phone_book[i], i);
        }
        
        for(int i=0; i<phone_book.length; i++){
            String checker = phone_book[i];
            for(int j=0; j<checker.length(); j++){
                if(map.containsKey(checker.substring(0,j))) return false;       
            }
        }
        return true;
    }
}