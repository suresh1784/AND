package patterns.mock;

import java.util.*;
import java.text.*;

/*
 * Sysdig Java Interview:
 * (1) Print people sorted by first name.
 * (2) Print people sorted by last name (use first name as tie-breaker if same last names).
 * (3) Print people born after 1945-01-01 (sorted by first name).
 *
 * Please note:
 *   Output from all three parts should be of the form "firstName lastName DOB"
 *   (see below for example output).
 */

/*
 * This class is provided as a container for test data, your solution
 * only needs to use Data.exampleData and doesn't need to be written in
 * the Data class.
 */
class Data {
    /*
     * Feel free to add additional data sets for testing/experimenting.
     * Data is formatted 'firstName,lastName,DOB(yyyy-MM-dd)'.
     */
    static final List<String> exampleData = new ArrayList<>();

    static {
        exampleData.add("Meryl,Streep,1949-06-22");
        exampleData.add("Kathrine,Hepburn,1907-05-12");
        exampleData.add("Audrey,Hepburn,1929-05-04");
        exampleData.add("Archie,Panjabi,1972-05-31");
        exampleData.add("Kerry,Washington,1977-01-31");

        /*
         * Example output for this data:

          People sorted by first name:
          Archie Panjabi 1972-05-31
          Audrey Hepburn 1929-05-04
          Kathrine Hepburn 1907-05-12
          Kerry Washington 1977-01-31
          Meryl Streep 1949-06-22

          People sorted by last name:
          Audrey Hepburn 1929-05-04
          Kathrine Hepburn 1907-05-12
          Archie Panjabi 1972-05-31
          Meryl Streep 1949-06-22
          Kerry Washington 1977-01-31

          People born after 1945-01-01 (sorted by first name):
          Archie Panjabi 1972-05-31
          Kerry Washington 1977-01-31
          Meryl Streep 1949-06-22

         */
    }
}


/*
 * Coderpad uses a static Solution.main method as its entry point.
 * See https://coderpad.io/languages#java for available libraries.
 */
class Solution {
    public static void main(final String[] args) {

        // Example use of Data.exampleData

        List<Person> personListLastName= new ArrayList<>();
        List<Person> personListFirstName= new ArrayList<>();
        List<Person> personList= new ArrayList<>();




        for (final String record : Data.exampleData) {
            String[] str = record.split(",");
            String firstName = str[0].trim();
            String lastName = str[1].trim();
            String birthDate = str[2].trim();
            String year  = birthDate.substring(0,4);
            int intYear = Integer.parseInt(year);

            personListLastName.add(new Person(lastName, firstName , birthDate));
            personListFirstName.add(new Person(lastName, firstName , birthDate));
            if (intYear> 1945){
                personList.add(new Person(lastName, firstName , birthDate));
            }// if

        }

        personListFirstName.sort((a, b) -> {
            if (!a.firstName.equalsIgnoreCase(b.firstName)) {
                return a.firstName.compareTo(b.firstName);
            } else {
                return a.lastName.compareTo(b.lastName);
            }
        });





        personListLastName.sort((a, b) -> {
            if (!a.lastName.equalsIgnoreCase(b.lastName)) {
                return a.lastName.compareTo(b.lastName);
            } else {
                return a.firstName.compareTo(b.firstName);
            }
        });



        personList.sort((a, b) -> {
            if (!a.firstName.equalsIgnoreCase(b.firstName)) {
                return a.firstName.compareTo(b.firstName);
            } else {
                return a.lastName.compareTo(b.lastName);
            }
        });

//       System.out.println(personListLastName);

//       System.out.println(personListFirstName);

//       System.out.println(personList);



        for (Person p : personListFirstName){
            System.out.println(p.firstName + " " + p.lastName + " " + p.birthDate);
        }
        System.out.println("");

        for (Person p : personListLastName){
            System.out.println(p.firstName + " " + p.lastName + " " + p.birthDate);
        }// for
        System.out.println("");

        System.out.println("");
        for (Person p : personList){
            System.out.println(p.firstName + " " + p.lastName + " " + p.birthDate);
        }
        System.out.println("-------------------");
        for (Person p : personList){
            System.out.println(p.toString());
        }

        System.out.println("<><><>>");

        System.out.println(personList);

    } // main


}// person

class  Person {
    String lastName;
    String firstName;
    String birthDate;

    public Person(String lastName, String firstName, String birthDate){
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
    }

    @Override
    public String toString(){
        return firstName + " "+lastName + " "+birthDate;
    }


}
