public class Palindrome {

    public static boolean isPalindrome(String phrase) {
        int[] table = makeTable(phrase);
        return checkTable(table);
    }

    public static boolean checkTable(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    public static int getCharNum(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int cur = Character.getNumericValue(c);
        if (a <= cur && cur <= z) {
            return cur - a;
        }
        return -1;
    }

    public static int[] makeTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') -
                Character.getNumericValue('a') + 1];
        for (char ch : phrase.toCharArray()) {
            int x = getCharNum(ch);
            if (x != -1) {
                table[x]++;
            }
        }
        return table;
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome("who are you uoy era ohw"));
    }
}
