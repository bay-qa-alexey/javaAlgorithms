//n!=n*(n-1)*(n-2)*..*1



public class Factorial {

    static public void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println(factorial.factorial(10));
    }

    public int factorial(int n) {
        if(n <= 1) return 1;
        return n * factorial(n-1);
    }

}
