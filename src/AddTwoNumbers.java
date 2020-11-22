import org.junit.Test;

import java.util.*;

public class AddTwoNumbers {
    @Test
    public void test(){
        String s = "qwer123456qa";

        Queue<Character> subStringStack = new LinkedList<>();
        int maxLength = 0;
        //change to charArray
        char[] chars = s.toCharArray();
        for(char ch: chars){
            while (subStringStack.contains(ch)){
                subStringStack.poll();
            }
            subStringStack.add(ch);
            maxLength = subStringStack.size() > maxLength? subStringStack.size(): maxLength;
        }
        System.out.println(maxLength);
    }

    @Test
    public void test2(){
        String s = "abcabcbb";

        int left = 0;
        int right = 0;
        int sLength = s.length();
        int maxLength = 0;
        HashSet<Character> characters = new HashSet<>();

        while (right < sLength && left <sLength){
            if(!characters.contains(s.charAt(right))){
                characters.add(s.charAt(right));
                maxLength = Math.max(right - left + 1, maxLength);
                right++;
            }else {
                characters.remove(s.charAt(left));
                left++;
            }
        }
        System.out.println(maxLength);
    }

    @Test
    public void test3(){
        String s = "abcdbadc";

        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        int left = 0;
        int maxLenth = 0;
        for(int right = 0; right < s.length(); right++){
            if(characterIntegerHashMap.containsKey(s.charAt(right))){
                left = Math.max(left, characterIntegerHashMap.get(s.charAt((right))) + 1);
            }
            characterIntegerHashMap.put(s.charAt(right), right);
            maxLenth = Math.max(maxLenth, right - left + 1);
        }
        System.out.println(maxLenth);
    }
}
