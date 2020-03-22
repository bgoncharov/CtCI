public class URLify {

    public static void spaceChange (char[] str, int lgth) {
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < lgth; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        index = lgth + spaceCount * 2;
        if (lgth < str.length) str[lgth] = '\0';
        for (i = lgth - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }

    public static int lastChar (char[] str) {
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] != ' ') {
                return i;
            }
        }
        return -1;
    }

    public static String charArrayToString(char[] array) {
        StringBuilder buffer = new StringBuilder(array.length);
        for (char c : array) {
            if (c == 0) {
                break;
            }
            buffer.append(c);
        }
        return buffer.toString();
    }

    public static void main(String[] args) {

        String str = "Mr John Smith    ";
        char[] arr = str.toCharArray();
        int trueLength = lastChar(arr) + 1;
        spaceChange(arr, trueLength);
        System.out.print("\"" + charArrayToString(arr) + "\"");
    }
}
