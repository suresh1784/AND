package algorithm.sort;

// https://github.com/csip-uga/archive/blob/62c1b1f4608b424c3049721383a53d6ca00dd35e/2019-04-08/charge_filter.py
//https://csip-uga.github.io/problems/2019-04-08/README

public class Radar {

    public static class Charge {
        String cardCountry ;
        String currency;
        String ipCountry;
        Integer amount;

        public Charge(String cardCountry, String currency, Integer amount, String ipCountry ){
            this.cardCountry = cardCountry;
            this.currency = currency;
            this.amount = amount;
            this.ipCountry = ipCountry;
        }
    }


    static boolean isRadar(String[] inputs){
        for (String input : inputs){
            String[] data  = input.split(":");
            if (data[0].equals("CHARGE")){
                System.out.println(data[1]);
            }

            if (data[0].equals("ALLOW")){
                System.out.println(data[1]);
                String rule = data[1];
                System.out.println("Rule "+rule);
                String[] r1 = rule.trim().split(" ");
                for (String r : r1){
                    System.out.println(r);
                }

                if (r1[0].equals("amount")){
                    System.out.println("Result ----> "+ isAmount(r1[1], Integer.parseInt(r1[2]),10));
                }
            }

            if (data[0].equals("BLOCK")){
                System.out.println(data[1]);
                String rule = data[1];
                System.out.println("Rule "+rule);
                if (rule.contains("AND") || rule.contains("OR")){
                    String[] rules = rule.trim().split("AND");
                    System.out.println("Rules --- > "+ rules[0]);
                    System.out.println("Rules --- > "+ rules[1]);
                }

                String[] r1 = rule.split(" ");
                for (String r : r1){
                    System.out.println(r);
                }
            }
        }

        return false;
    }

    static boolean isAmount(String operator , int amount , int chargeInput){
        if (operator.equals("<")){
            if (chargeInput < amount){
               return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
      String[] input = {
              "CHARGE: card_country=US&currency= USD&amount=150&ip_country=CA",
              "ALLOW: amount < 100",
              "BLOCK: card_country != CA AND amount > 100",
      };

        System.out.println(isRadar(input));

    }

}


