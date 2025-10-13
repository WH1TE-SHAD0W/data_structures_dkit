import utils.DynamicArray;

public class TestDynamicArray {
    public static void main(String[] args) {
        int [] sourceInfo = {1,2,3,4,5,6};
        DynamicArray myList = new DynamicArray();

        for(int num: sourceInfo) {
            myList.add(num);
        }

        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i) + ", ");
        }

        System.out.println(myList.indexOf(5));
        System.out.println(myList.contains(5));
    }
}
