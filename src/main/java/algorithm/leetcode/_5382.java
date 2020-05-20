package algorithm.leetcode;

import java.util.*;

public class _5382 {
    public String entityParser(String text) {
        Map<String, String> map = new HashMap<>();
        map.put("quot", "\"");
        map.put("apos", "'");
        map.put("amp", "&");
        map.put("gt", ">");
        map.put("lt", "<");
        map.put("frasl", "/");

        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        boolean isAmp = false;
        for (char ch : text.toCharArray()){
            if (ch=='&'){
                isAmp = true;
                if (sb1.length()>0){
                    sb.append('&'+sb1.toString());
                }

                sb1 = new StringBuilder();
            }else if (ch==';'){
                if (map.get(sb1.toString())!= null){
                    sb.append(map.get(sb1.toString()));
                }else {
                    if (isAmp) {
                        sb.append('&' + sb1.toString() + ';');
                    }else {
                        sb.append(sb1.toString() + ';');
                    }
                }
                isAmp = false;
                sb1 = new StringBuilder();
            }
            else if (!isAmp){
                sb.append(ch);
            } else if (isAmp){
                sb1.append(ch);
                if (sb1.length() > 5){
                    sb.append('&'+sb1.toString());
                    isAmp = false;
                    sb1 = new StringBuilder();
                }
            }
        }

        return sb.toString();
    }
}
