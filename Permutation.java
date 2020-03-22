public class Permutation {

    static boolean isPermut(String str1, String str2) {

        if (str1.length() != str2.length())
            return false;

        int[] letters = new int[128];
        for (int i = 0; i < str1.length(); i++)
            letters[str1.charAt(i)]++;

        for (int i = 0; i < str2.length(); i++) {
            letters[str2.charAt(i)]--;
            if (letters[str2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String[][] pairs = {{"boris", "robis"}, {"hello", "abcde"}};

        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];

            boolean check = isPermut(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + check);
        }
    }
}
