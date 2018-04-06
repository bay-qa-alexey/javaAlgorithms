

public class SumOfDigits {

    static public void main(String[] args) {
        SumOfDigits sumOfDigits = new SumOfDigits();
        int num = 12345;
        System.out.println(sumOfDigits.sumOfDigits(num));
    }

    public int sumOfDigits(int num) {
        if (num/10 == 0) return num;
        return num%10 + sumOfDigits(num/10);
    }

}
