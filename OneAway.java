public class OneAway {

    public static boolean check(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return oneReplace(s1, s2);
        } else if (s1.length() + 1 == s2.length()) {
            return oneEdit(s1, s2);
        } else if (s1.length() - 1 == s2.length()) {
            return oneEdit(s2, s1);
        }
        return false;
    }

    public static boolean oneReplace(String s1, String s2) {
        boolean diff = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (diff) {
                    return false;
                }
                diff = true;
            }
        }
        return true;
    }

    public static boolean oneEdit(String s1, String s2) {
        int n1 = 0;
        int n2 = 0;

        while (n2 < s2.length() && n1 < s1.length()) {
            if (s1.charAt(n1) != s2.charAt(n2)) {
                if (n1 != n2) {
                    return false;
                }
                n2++;
            } else {
                n1++;
                n2++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(check("pale", "ple"));
        System.out.println(check("pale", "bale"));
        System.out.println(check("pale", "bae"));
    }
}
