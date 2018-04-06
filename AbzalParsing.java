/*
Given the following inputs, we expect the corresponding output:
        * "1a2b3c" => 6 (1+2+3)
        * "123ab!45c" => 168 (123+45)
        * "abcdef" => 0 (no Integers in String)
        * "0123.4" => 127 (0123+4)
        * "dFD$#23+++12@#T1234;/.,10" => 1279 (23+12+1234+10)
        *"12a-10b" => 2 (12-10)
        * 12-adsf-10 12-10
*/

import java.util.ArrayList;
import java.util.List;

public class AbzalParsing {

    static public void main(String[] args) {
        AbzalParsing abzalParsing = new AbzalParsing();
        String[] str = new String[6];
        str[0] = "1a2b3c";                     //=> 6 (1+2+3)
        str[1] = "123ab!45c";                  // => 168 (123+45)
        str[2] = "abcdef";                     //=> 0 (no Integers in String)
        str[3] = "0123.4";                     // => 127 (0123+4)
        str[4] = "dFD$#23+++12@#T1234;/.,10";  // => 1279 (23+12+1234+10)
        str[5] = "12a-10b";                    // => 2 (12-10)

        abzalParsing.abzalPars(str[4]);
    }


    public void abzalPars(String x){
        System.out.println(x);
        List<String> myList = new ArrayList<>();
        String tmp_str = "";
        char tmp_char;
        int flag_digit=0;
        int flag_minus=0;
        for(int i=0;i<x.length();i++){
            tmp_char=x.charAt(i);

            if(tmp_char=='0'||tmp_char=='1'||tmp_char=='2'||tmp_char=='3'||tmp_char=='4'||tmp_char=='5'||tmp_char=='6'||tmp_char=='7'||tmp_char=='8'||tmp_char=='9'){
                if(flag_digit == 0 && flag_minus == 0){
                    tmp_str=tmp_str+String.valueOf(tmp_char);
                    flag_digit=1;
                } else {
                    if(flag_digit == 1 && flag_minus == 0){
                        tmp_str=tmp_str+String.valueOf(tmp_char);
                    } else {
                        if(flag_digit == 0 && flag_minus == 1){
                            myList.add(tmp_str);
                            tmp_str="";
                            tmp_str=tmp_str+String.valueOf(tmp_char);
                            flag_digit=1;
                            flag_minus=0;
                        }
                    }
                }
            }

            if(tmp_char == '-'){
                if(flag_digit == 0 && flag_minus == 0){
                    tmp_str=tmp_str+String.valueOf(tmp_char);
                    flag_minus=1;
                } else {
                    if(flag_digit == 1 && flag_minus == 0){
                        myList.add(tmp_str);
                        tmp_str="";
                        tmp_str=tmp_str+String.valueOf(tmp_char);
                        flag_digit=0;
                        flag_minus=1;
                    } else {
                        if(flag_digit == 0 && flag_minus == 1){
                            tmp_str=tmp_str+String.valueOf(tmp_char);
                        }
                    }
                }
            }

            if(tmp_char!='0'&&tmp_char!='1'&&tmp_char!='2'&&tmp_char!='3'&&tmp_char!='4'&&tmp_char!='5'&&tmp_char!='6'&&tmp_char!='7'&&tmp_char!='8'&&tmp_char!='9'&&tmp_char != '-'){
                if(flag_digit == 0 && flag_minus == 0){
                    //tmp_str=tmp_str+String.valueOf(tmp_char);
                    //flag_minus=1;
                } else {
                    if(flag_digit == 1 && flag_minus == 0){
                        myList.add(tmp_str);
                        tmp_str="";
                        //tmp_str=tmp_str+String.valueOf(tmp_char);
                        flag_digit=0;
                    } else {
                        if(flag_digit == 0 && flag_minus == 1){
                            myList.add(tmp_str);
                            tmp_str="";
                            //tmp_str=tmp_str+String.valueOf(tmp_char);
                            flag_minus=0;
                        }
                    }
                }
            }

        }

        if(tmp_str != "") myList.add(tmp_str);

        //System.out.println(myList);

        for(int i=0;i<myList.size();i++){
            if(myList.get(i).startsWith("-")){
                myList.set(i, "-");
            }
        }

        //System.out.println(myList);

        List<Integer> myMinuses = new ArrayList<>();
        flag_minus=0;
        for(int i=0;i<myList.size();i++){
            if(myList.get(i).startsWith("-")){
                if(flag_minus == 0){
                    flag_minus = 1;
                } else {
                    myMinuses.add(i);
                }
            } else {
                flag_minus=0;
            }
        }
        for(int i=myMinuses.size()-1;i>=0;i--){
            myList.remove((int)myMinuses.get(i));
        }

        //System.out.println(myList);

        while(myList.get(myList.size()-1) == "-"){
            myList.remove(myList.size()-1);
        }

        //System.out.println(myList);

        myMinuses.clear();
        for(int i=0;i<myList.size()-1;i++){
            if(myList.get(i) !="-" && myList.get(i+1) !="-"){
                myMinuses.add(i+1);
            }
        }

        for(int i=myMinuses.size()-1;i>=0;i--){
            myList.add((int)myMinuses.get(i),"+");
        }

        if(myList.get(0) != "+" && myList.get(0) != "-"){
            myList.add(0, "+");
        }

        //System.out.println(myList);

        myMinuses.clear();
        int total=0;
        for(int i=0;i<myList.size();i=i+2){
            if(myList.get(i) == "+"){
                total=total + Integer.valueOf(myList.get(i+1));
            } else {
                total=total - Integer.valueOf(myList.get(i+1));
            }
        }

        //System.out.println(total);

        String rezult=String.valueOf(total)+"(";
        for(int i=1;i<myList.size();i++){
            rezult=rezult+myList.get(i);
        }
        rezult=rezult+")";
        System.out.println(rezult);

    }

}