// 35. Search Insert Position (easy)
// Given a sorted array and a target value, return the index if the target is found.
// If not, return the index where it would be if it were inserted in order.
// You may assume no duplicates in the array.
//binarySearch time complexity = log2(n)


public class BinarySearch {

    static public void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] my = {2, 5, 7, 10, 12, 15, 95};
        System.out.println(binarySearch.binarySearch(my, 12, 0, my.length-1));
    }

    public int binarySearch(int[] myArray, int target, int left, int right) {
        if(left > right) {return left;}
        int middle = (left + right)/2;
        if(target == myArray[middle]) {return middle;}
        if(target < myArray[middle]) {
            right = middle - 1;
        }
        else {
            left = middle + 1;
        }
        return binarySearch(myArray, target, left, right);
    }

}
