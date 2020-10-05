package algorithm.recursion;

public class OneEdit {

    public static void main(String[] args) {
        String s = "cats";
        String t = "casts";

//        System.out.println(oea.isOneEditDistance("cat", "dog"));
//        System.out.println(oea.isOneEditDistance("cat", "cats"));
//        System.out.println(oea.isOneEditDistance("cat", "cut"));
//        System.out.println(oea.isOneEditDistance("cats", "casts"));
//        System.out.println(oea.isOneEditDistance("catsts", "casts"));

        if (s != null && t != null) {
            char[] ch1 = s.toCharArray();
            char[] ch2 = t.toCharArray();
            int m = ch1.length;
            int n = ch2.length;
            Boolean result = oneEdit(ch1,ch2,m-1,n-1, 0,0,0);
            System.out.println("result "+result);
        }
    }//main


    public static Boolean oneEdit(char[] s, char[] t, int m, int n, int i, int j, int count) {
        if (Math.abs(m - n) > 1) {
            return false;
        }

        if (count > 1) {
            return false;
        }

        if (i == m && j == n) {
            if (count == 1) {
                return true;
            } else {
                return false;
            }
        }//if


        if (i == m || j == n) {
            if ((Math.abs(m - n) == 1) && count == 0) {
                return true;
            } else {
                return false;
            }
        } //if

        if (s[i] == t[j]) {
            return oneEdit(s, t, m, n, i + 1, j + 1, count);
        } else if (m > n) {
            return oneEdit(s, t, m, n, i + 1, j, count + 1);
        } else if (n > m) {
            return oneEdit(s, t, m, n, i, j + 1, count + 1);
        } else if (m == n) {
            return oneEdit(s, t, m, n, i + 1, j + 1, count + 1);
        } else{
            return true;
        }


    } //oneEdit

} //OneEdit