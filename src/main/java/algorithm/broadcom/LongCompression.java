package algorithm.broadcom;
import java.util.ArrayList;
import java.util.List;


public class LongCompression {



    // we need 6 byte output
    static char  ch[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
    'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','!','@','#','$','%','^','&','*','(',')','-','_','+',
    '=','{','}','[',']',':',';',',','.','/','?'};

    static  String base = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%^&*()-_+={}[]:;,./?";

    public static char getChar(int num){
        return (char)num;
    }

    public static String compressLong(Long num){
        String compressedValue="";
        int rem;

        while(num != 0)
        {
            Long longRem=(num%64);
            rem = longRem.intValue();
            compressedValue= ch[rem] + compressedValue;
            num= num/64;
        }
        return compressedValue;
    }


    public static Long uncompress(String input){
        long result = 0 ;
        for (int i = 0; i < input.length(); i++)
        {
            char ch = input.charAt(i);
            int  in= base.indexOf(ch);
            result = 64*result + in;
        }
        return result;
    }

    public static byte[] compressData(List<Long> lists){
        StringBuilder sb = new StringBuilder();
        sb.append("<64BaseConversion>");
        for (Long l : lists){
            sb.append("<");
            sb.append(compressLong(l));
            sb.append(">");

        }
        System.out.println(sb.toString());
        return sb.toString().getBytes();
    }

    public static List<Long> unCompressData(byte[] buffer){
        List<Long> result = new ArrayList<>();
        char c;
        StringBuffer sb =new StringBuffer();
        for(byte b:buffer) {
            c = (char)b;
            if (c != '>' && c!='<') {
                sb.append(c);
            }
            if (c == '>'){
                if (!sb.toString().equals("64BaseConversion")){
                    System.out.println(sb.toString());
                    result.add(uncompress(sb.toString()));
                    sb = new StringBuffer();
                }else {
                    sb = new StringBuffer();
                }
            }
        }
      return result;
    }


    public static void main(String[] args){
        List<Long> lists = new ArrayList<>();
        lists.add(123L);
        lists.add(5L);
        lists.add(123456L);
        lists.add(128L);
        System.out.println(unCompressData(compressData(lists)));
    }
}
