public class longestPalindromeSubString {
    public static String s = "abacab";

    public static void main(String[] args) {
        if(s.length() == 0){
            return;
        }else if(s.length() == 1){
            return;
        }

        int maxLength = 0;
        int l = 0;
        int r = 0;

        for(int left = 0; left < s.length(); left++){
            if(maxLength > (s.length() - left)){
                break;
            }
            for(int right = s.length() - 1; right > left; right--) {
                int offset = -1;
                do{
                    offset++;
                    if (left + offset >= right - offset) {
                        if(maxLength < (right - left + 1)){
                            maxLength = right - left + 1;
                            l = left;
                            r = right;
                            System.out.println(l + " " + r + " " + maxLength);
                        }
                        break;
                    }
                }while (s.charAt(left + offset) == s.charAt(right - offset));
            }
        }
        System.out.println(s.substring(l, r+1));
    }
}
