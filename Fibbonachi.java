//0 1 1 2 3 5 8 13 21 34 ...
//0 1 2 3 4 5 6 7  8  9


public class Fibbonachi {

    static public void main(String[] args) {
        Fibbonachi fibbonachi = new Fibbonachi();
        System.out.println(fibbonachi.fibbonachi(8));
    }

    public int fibbonachi(int num) {
        if(num <= 2) {return 1;}
        return fibbonachi(num-1) + fibbonachi(num-2);
    }

}
