// given an integer find the next bigger integer which has some digits Ex: 123->132->213->231 ... "


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextBiggerIntegerSameDigits {
    public static void main(String[] args) {

        NextBiggerIntegerSameDigits nextBiggerIntegerSameDigits = new NextBiggerIntegerSameDigits();
        nextBiggerIntegerSameDigits.start(123);

    }

    public void start(int x){
        int modified;
        System.out.println(x);
        while(true){
            modified= helper1(x);
            if(x==modified){break;}
            else {System.out.println(modified);x=modified;}

        }
    }

    public int helper1(int x){
        int r = x;
        char[] a= Integer.toString(x).toCharArray();
        for(int i=a.length-2;i>=0;i--) {
            if(helper2(i, a)){
                String rez = String.valueOf(a);
                r = Integer.valueOf(rez);
                break;
            }
        }
        return r;
    }


    public boolean helper2(int begin, char[] a){
        List<Integer> intList = new ArrayList<>();

        for(int i=begin;i<a.length;i++){
            intList.add(Character.getNumericValue(a[i]));
        }

        int bigger=intList.get(0);

        Collections.sort(intList);

        for(int i=0;i<intList.size();i++){
            if(intList.get(i) > bigger) {
                a[begin] = Integer.toString(intList.get(i)).charAt(0);
                intList.remove(i);
                for(int j=0;j<intList.size();j++){
                    a[begin+1+j]=Integer.toString(intList.get(j)).charAt(0);;
                }
                return true;
            }
        }
        return false;
    }

}