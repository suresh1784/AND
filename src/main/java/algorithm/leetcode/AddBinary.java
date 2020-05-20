package algorithm.leetcode;

public class AddBinary {

    public static void main(String[] args){
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a,b));
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char carry = '0' ;

        int aLength = a.length()-1;
        int bLength = b.length()-1;
        int count = Math.max(aLength,bLength);
        char aVal = '0';
        char bVal = '0';
        char cVal = '0' ;

        while (count>=0 ){

            if (aLength>=0){
                aVal = a.charAt(aLength);
                aLength--;
            }else {
                aVal = 0 ;
            }

            if (bLength>=0){
                bVal = b.charAt(bLength);
                bLength--;
            }else {
                bVal =0;
            }

            if (aVal =='1' || bVal=='1'){
                if (aVal =='1' && bVal=='1'){
                    if (carry =='0') {
                        carry = '1';
                        cVal = '0';
                    }else {
                        carry = '1';
                        cVal = '1';
                    }
                } else {
                    if (carry =='0') {
                        carry = '0';
                        cVal = '1';
                    }else {
                        carry = '1';
                        cVal = '0';
                    }
                }

            }else{
                cVal = carry;
                carry = '0' ;
            }
            sb.insert(0,cVal);
            count--;
        }
        if (carry=='1')
            sb.insert(0,carry);

        return sb.toString();
    }
}
