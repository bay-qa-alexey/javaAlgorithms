//151. Reverse Words in a String (medium)


public class ReverseWordsInString {

    static public void main(String[] args) {
        ReverseWordsInString reverseWordsInString = new ReverseWordsInString();
        String s = "    sdf    seedf    rr ";
        System.out.println(s);
        System.out.println("\"" + reverseWordsInString.reverseWords(s) + "\"");
        }

    //(fast)
    public String reverseWords(String s) {
        s = s.trim();
        if(s.equals("")) {return s;}

        String tmp = "";
        String [] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i=ss.length-1; i >= 0; i--) {
            tmp = ss[i].trim();
            if (!tmp.equals("")) {
                sb.append(tmp);
                if (i != 0) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }

    //(slow)
    public String reverseWords2(String s) {
        if (s.length() == 0) {return s;}

        String rez = "";
        int i = 0;
        int j = 0;

        while(i<s.length()) {
            if(s.charAt(i) == ' ') {
                i++;
            } else {
                j = s.substring(i).indexOf(' ');
                if(j != -1) {
                    rez = " " + s.substring(i, j+i) + rez;
                    i = j + i;
                } else {
                    rez = " " + s.substring(i) + rez;
                    i = s.length();
                }
            }
        }
        return (rez.length() > 0)?rez.substring(1):rez;
    }

}