

public class PalindromeString {

    static public void main(String[] args) {
        PalindromeString palindromeString = new PalindromeString();
        String str = "qweewq";
        System.out.println(palindromeString.palindromStr(str));
    }

    public boolean palindromStr(String str) {
        if (str.length() <= 1) {return true;}
        else {
            if (str.charAt(0) == str.charAt(str.length()-1)) {
                return palindromStr(str.substring(1, str.length() - 1));
            } else {
                return false;
            }
        }
    }

}
