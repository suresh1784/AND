package algorithm.karat;

import java.io.*;
import java.util.*;

/*
We have some clickstream data that we gathered on our client's website. Using cookies, we collected snippets of users' anonymized URL histories while they browsed the site. The histories are in chronological order and no URL was visited more than once per person.

Write a function that takes two users' browsing histories as input and returns the longest contiguous sequence of URLs that appears in both.

Sample input:

user0 = ["/start.html", "/pink.php", "/register.asp", "/orange.html", "/red.html"]
user1 = ["/start.html", "/green.html", "/blue.html", "/pink.php", "/register.asp", "/orange.html"]
user2 = ["/red.html", "/green.html", "/blue.html", "/pink.php", "/register.asp"]
user3 = ["/blue.html", "/logout.php"]


// user0 and user1

// user0 master loop


Sample output:

findContiguousHistory(user0, user1)
   /pink.php
   /register.asp
   /orange.html

findContiguousHistory(user1, user2)
   /green.html
   /blue.html
   /pink.php
   /register.asp

findContiguousHistory(user0, user3)
   (empty)

findContiguousHistory(user2, user3)
   /blue.html

findContiguousHistory(user3, user3)
   /blue.html
   /logout.php


 */



class URL {


    static Map<String, Integer> calculateClicksByDomain(String[] counts){
        Map<String, Integer> domainMap = new HashMap<>();

        for (String countRecord: counts){
            String[] record= countRecord.split(",");
            int count = Integer.parseInt(record[0]); // 900
            String domainContent = record[1];
            String[] domain = domainContent.split("\\.");
            int length = domain.length-1;
            String dom  = "";
            for (int i = length; i >= 0 ; i--){

                if (i == length){
                    dom = domain[i];
                }else{
                    dom =  domain[i]+"."+dom;  // com
                }

                if (domainMap.get(dom)!= null){
                    int eCount =  domainMap.get(dom);
                    domainMap.put(dom, count+eCount);
                }else {
                    domainMap.put(dom, count);
                }
            }// for

        }// for
        return domainMap;
    }

    static List<String> findContiguousHistory(List<String> user1,List<String> user2){
        List<String> maxList = new ArrayList<>();

        int i = 0 ;
        int j = 0 ;

        int userLen1 = user1.size()-1;
        int userLen2 = user2.size()-1;

        List<String> tempList = new ArrayList<>();
        while (i <= userLen1 && j <= userLen2){

            String userUrl = user1.get(i); // start
            System.out.println("userurl"+ userUrl);
            System.out.println(Collections.binarySearch(user2, userUrl));
            if (user2.contains(userUrl)){//user2.contains(userUrl)
                //
                int index =  user2.indexOf(userUrl);
           //     System.out.println("index"+index);
          //      System.out.println("j"+j);
                if  (index == j){

                    tempList.add(userUrl);
                    j++;
                }else {
                    if (tempList.size() > maxList.size()){
                        maxList = tempList;
                    }
                    tempList = new ArrayList<>();
                    tempList.add(userUrl);
                    j =  index+1;
                }

            }else {
                if (tempList.size() > maxList.size()){
                    maxList = tempList;
                }
                // tempList = new ArrayList<>();

            }

            i++;

        }// while

        if (tempList.size() > maxList.size()){
            maxList = tempList;
        }

        return maxList;

    }//findContiguousHistory


    public static void main(String[] args) {
//     String[] counts = {
//       "900,google.com",
//       "60,mail.yahoo.com",
//       "10,mobile.sports.yahoo.com",
//       "40,sports.yahoo.com",
//       "300,yahoo.com",
//       "10,stackoverflow.com",
//       "2,en.wikipedia.org",
//       "1,es.wikipedia.org",
//       "1,mobile.sports",
//       "1,google.co.uk"
//     };


//     System.out.println(calculateClicksByDomain(counts));

        List<String> user0 = Arrays.asList("/start.html", "/pink.php", "/register.asp", "/orange.html", "/red.html" );
        List<String> user1 = Arrays.asList("/start.html", "/green.html", "/blue.html", "/pink.php", "/register.asp", "/orange.html");
        List<String> user2 = Arrays.asList("/red.html", "/green.html", "/blue.html", "/pink.php", "/register.asp");
        List<String> user3 = Arrays.asList("/blue.html", "/logout.php");

        System.out.println(findContiguousHistory(user1, user2));

    }
}
