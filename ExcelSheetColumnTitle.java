//168. Excel Sheet Column Title (easy)



public class ExcelSheetColumnTitle {

    static public void main(String[] args) {
        ExcelSheetColumnTitle excelSheetColumnTitle = new ExcelSheetColumnTitle();
        int num = 234;
        System.out.println(excelSheetColumnTitle.convertToTitle(num));
    }

    public String convertToTitle(int n) {
        char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        if(n < 1) return "Incorrect input (of column number)!: " + String.valueOf(n);

        int i = n/26;
        int j = n%26;

        if(j != 0) {
            if(i>1) {
                return convertToTitle(i) + String.valueOf(alphabet[j-1]);
            } else {
                if(i == 1) {
                    return String.valueOf(alphabet[i - 1]) + String.valueOf(alphabet[j - 1]);
                } else {
                    return String.valueOf(alphabet[j - 1]);
                }
            }
        }
        else {
            if (i>1) {
                i = i - 1;
                j = 26;
                return convertToTitle(i) + String.valueOf(alphabet[j-1]);
            } else {
                j = 26;
                return String.valueOf(alphabet[j-1]);
            }
        }
    }
}
