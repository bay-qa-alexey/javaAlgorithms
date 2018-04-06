//8. String to Integer (atoi) (medium)


public class StringToInteger {

    static public void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
        String str = "-2147483649";
        System.out.println(stringToInteger.myAtoi(str));
    }

    public int myAtoi(String str) {
        long rezult = 0;
        int sign = 1;
        int counter_plus = 0;
        int counter_minus = 0;
        int j=0;

        for(j=0;j<str.length();j++) {
            if(str.charAt(j) != ' ') {break;}
        }
        if(j == str.length()) {return 0;}

        for(;j<str.length();j++) {
            if (str.charAt(j) == '+') {
                counter_plus++;
            } else {
                if (str.charAt(j) == '-') {
                    counter_minus++;
                } else {
                    break;
                }
            }
        }
        if(j == str.length()) {return 0;}

        if(counter_plus + counter_minus > 1) {return 0;}
        if(counter_minus > 0) {sign = -1;}

        for(int i=j; i<str.length(); i++) {
            if(Character.isDigit(str.charAt(i))) {
                rezult = 10 * rezult + Character.getNumericValue(str.charAt(i));
                if(sign >= 0) {
                    if(rezult >= Integer.MAX_VALUE ) {
                        return Integer.MAX_VALUE;
                    }
                } else {
                    if(sign*rezult <= Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                }
            } else {
                break;
            }
        }
        return (int) rezult * sign;
    }

}
