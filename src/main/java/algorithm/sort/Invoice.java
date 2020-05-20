package algorithm.sort;
import java.util.*;

public class Invoice {

    public static class Details implements Comparable<Details>{
        String action;
        Integer id;
        Integer amount;
        String currency;

        @Override
        public String toString() {
            return "Action : " +action + " ID " + id + " Amount "+ amount + " currency " + currency ;
        }

        @Override
        public int compareTo(Details that){
            if (!action.equals(that.action)){
                return action.compareTo(that.action);
            }

           // if (id != that.id){
                return Integer.compare(id, that.id);
           // }


//            if (!action.equals(that.action)){
//               if (action.equals("FINALIZE") && that.action.equals("CREATE")){
//                   return -1;
//               }
//
//                if (action.equals("CREATE") && that.action.equals("PAY")){
//                    return -1;
//                }
//
//                if (action.equals("FINALIZE") && that.action.equals("PAY")){
//                    return -1;
//                }
//
//                return 1;
//            }
//
//            return 0;
        }


        public Details(String action, Integer id, Integer amount, String currency){
            this.action = action;
            this.id = id;
            this.amount = amount;
            this.currency = currency;
        }
    }

    public void processInvoice1(List<String> invoices){
        List<Details> detailList = new ArrayList<>();
        for (String invoice : invoices){
            String[] str = invoice.split(",");
            if (str[3].equals("USD"))
                detailList.add(new Details(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]), str[3] ) );
        }
        Collections.sort(detailList);

        System.out.println(detailList);
    }

    public static void processInvoice(List<String> invoices){
        List<Details> detailList = new ArrayList<>();
        for (String invoice : invoices){
            String[] str = invoice.split(",");
            if (str[3].equals("USD"))
            detailList.add(new Details(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]), str[3] ) );
        }
        Collections.sort(detailList);

        System.out.println(detailList);
    }

    public static void processInvoiceV1(List<String> invoices){
        invoices.sort((a,b) ->{
            int val1 = Integer.parseInt(a.split(",")[1]);
            int val2 = Integer.parseInt(b.split(",")[1]);
            if (val1!= val2) {
                return Integer.compare(val1, val2);
            }else {
                String a1 = a.split(",")[0];
                String a2 = b.split(",")[0];
                return a1.compareTo(a2);
            }

        });

        System.out.println(invoices);
    }


    public static void main(String[] args){

        // action (CREATE, FINALIZE, PAY), id, amount, currency
        String s1 = "FINALIZE,100,100,USD";
        String s2 = "CREATE,100,100,USD";
        String s3 = "PAY,101,100,USD";
        String s4 = "FINALIZE,101,100,USD";
        String s5 = "CREATE,101,100,USD";
        String s6 = "FINALIZE,102,100,USD";
        String s7 = "CREATE,102,100,USD1";
        String s8 = "PAY,100,100,USD";

        List<String> list = new ArrayList<>();
        Arrays.asList(s1,s2,s3,s4,s5,s6,s7,s8);
        list.addAll(Arrays.asList(s1,s2,s3,s4,s5,s6,s7,s8));
        processInvoice(list);


    }
}
