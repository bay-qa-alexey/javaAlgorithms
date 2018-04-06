//9. Palindrome Number (easy)


public class PalindromeNumber {

    static public void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        int num = 123321;
        System.out.println(palindromeNumber.isPalindrome(num));
    }


    public boolean isPalindrome(int x) {
        if (x<0) return false;
        if (x<10) return true;
        if (x%10 == 0) return false;
        int rezult = x;
        int reverse = 0;
        while(rezult > 0) {
            reverse = reverse * 10 + rezult%10;
            rezult = rezult/10;
        }
        return reverse == x;
    }

}
