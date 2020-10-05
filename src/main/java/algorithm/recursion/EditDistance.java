package algorithm.recursion;

public class EditDistance{

    public static void main(String[] args) {

        String str1 = "FOOD";
        String str2 = "FOODOOP";

        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int m = ch1.length;
        int n = ch2.length;



        System.out.println( "Not my solution"+editDist( str1 , str2 , str1.length(), str2.length()) );

       int result =  getEdit(ch1,ch2,m-1, n-1 , -1 , -1);
        System.out.println("result "+(result));

    }

    public static int getEdit(char[] s, char[] t , int m, int n , int i, int j){
        if (i>=m){
            return n-j-1;
        }

        if (j>=n){
            return m-i-1;
        }

        if (s[i+1] == t[j+1]){
         return    getEdit(s,t,m, n , i+1, j+1)	;

        } else {
            return 1+ min(getEdit(s,t,m, n , i+1, j),
                    getEdit(s,t,m, n , i, j+1),
                    getEdit(s,t,m, n , i+1, j+1)	);
        }

    } //getEdit

    static int min(int x,int y,int z)
    {
        if (x<=y && x<=z) return x;
        if (y<=x && y<=z) return y;
        else return z;
    }

    static int editDist(String str1 , String str2 , int m ,int n)
    {
        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (m == 0) return n;

        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0) return m;

        // If last characters of two strings are same, nothing
        // much to do. Ignore last characters and get count for
        // remaining strings.
        if (str1.charAt(m-1) == str2.charAt(n-1))
            return editDist(str1, str2, m-1, n-1);

        // If last characters are not same, consider all three
        // operations on last character of first string, recursively
        // compute minimum cost for all three operations and take
        // minimum of three values.
        return 1 + min ( editDist(str1,  str2, m, n-1),    // Insert
                editDist(str1,  str2, m-1, n),   // Remove
                editDist(str1,  str2, m-1, n-1) // Replace
        );
    }




} //EditDistance