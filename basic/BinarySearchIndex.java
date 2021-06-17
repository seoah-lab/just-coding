public class BinarySearchIndex {

    static int binarySearchBefore (int[] a, int n, int key) {
        int startIndex = 0;
        int lastIndex = n - 1;

        while (startIndex <= lastIndex) {
            int centerIndex = (startIndex + lastIndex)/2;

            if(a[centerIndex] == key) {
                while (centerIndex > startIndex) {
                    if(a[centerIndex - 1 ] != key) break;
                    centerIndex--;
                }
                return centerIndex;
            }

            if(a[centerIndex] < key) {
                startIndex = centerIndex + 1;
            } else if(a[centerIndex] > key) {
                lastIndex = centerIndex -1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

        int a[] = {1,2,3,3,5,6,7,8};
        int n = 8;
        int key = 3;

        System.out.println(binarySearchBefore(a, n, key));
    }
}
