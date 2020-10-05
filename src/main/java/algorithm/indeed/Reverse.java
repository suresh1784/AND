package algorithm.indeed;

public class Reverse{

    public static void main(String[] args) {
        String input = "<hi> reverse <hi> this is great </ Hello >";
        System.out.println("Reverse For " + reverse1(input.toCharArray()));
        reverse(input.toCharArray(),0 , 0, false, "","");

    }


    static String reverse1(char[] ch){

        String result = "";
        String temp = "";
        Boolean isReverse = false;
        int j = 0;
        for (int i = 0 ; i <= ch.length -1 ; i++){
            if (ch[i] == '<'){
                isReverse = false;
                result = result + temp;
                temp = "";
            } // if
            else if (ch[i] == '>'){
                isReverse = true;
                result = result + ch[i];
                i++;

                j++;

                if (i > (ch.length-j)){
                    break;
                }
            } // else if
            if (isReverse){

                temp = ch[i] +temp ;
            }else{
                result = result + ch[i] ;
            }

        } // for
        return result ;
    }


    static void reverse(char[] ch, int i, int j , Boolean isReverse , String temp, String temp1){
        if (i > ch.length-1-j ){
            System.out.println(temp1);
            return ;
        }

        if (ch[i] == '<'){
            isReverse = false;
            temp1 = temp1 + temp;

        }else if (ch[i] == '>'){
            temp1 = temp1+ch[i];
            i++;
            j++;
            if (i >= ch.length-1-j ){
                System.out.println(" ??? "+temp1);
                return ;
            }
            isReverse = true;
        }



        if (isReverse){
            reverse(ch, i+1, j,  isReverse , ch[i]+ temp , temp1);

        }else {
            reverse(ch, i+1, j, isReverse , temp , temp1+ch[i] );
        }




    }

}//reverse


