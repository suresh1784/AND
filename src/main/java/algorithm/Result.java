package algorithm;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Result {

    public static List<List<Integer>> txnSummary(int locationId, String transactionType) {
    List<List<Integer>> result = new ArrayList<>();
    return result;
    }

    public static void main(String[] args) {
        try {
            String transactionType = "debit";
            URL url = new URL("https://jsonmock.hackerrank.com/api/transactions/search?txnType="+transactionType);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            conn.getResponseMessage();

            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);

            }
            conn.disconnect();

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
    }

}
