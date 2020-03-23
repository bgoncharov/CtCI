public class Compression {

    public static String compress(String str) {
        String newStr = "";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                newStr += "" + str.charAt(i) + count;
                count = 0;
            }
        }
        return newStr.length() < str.length() ? newStr : str;
    }

    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
    }
}
