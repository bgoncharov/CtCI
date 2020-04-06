public class StackMin {

    public static int[] arr = null;

    public static void pop() {

    }

    public static void push() {

    }

    public void addMin(int i) {

        if (arr.length >= 0) {
            int j = arr[arr.length];
            if (i < j) {
                arr[arr.length + 1] = i;
            }
        } else {
            arr[0] = i;
        }
    }

    public void remMin(int i) {
        for (int j = 0; j < arr.length; j++) {
            if (i == arr[j]) {
                arr[j] = null;
            }
        }
    }

    public static void main (String[] args) {

    }
}