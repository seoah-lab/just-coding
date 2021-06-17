class Binary {
    public static int binary(int[] a, int n, int key) {
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int half = (start + end) / 2;
            if (key == a[half])
                return 1;
            if (key < a[half])
                end = half - 1;
            else if (key > a[half])
                start = half + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int n = 5;
        int key = 0;
        System.out.println(binary(a, n, key));
    }
}