package algorithm.karat;

/*
You are a developer for a university. Your current project is to develop a system for students to find courses they share with friends. The university has a system for querying courses students are enrolled in, returned as a ArrayList of (ID, course) pairs.

Write a function that takes in a ArrayList of (student ID number, course name) pairs and returns, for every pair of students, a ArrayList of all courses they share.

Sample Input:
student_course_pairs = [
    ["58", "Software Design"],
    ["58", "Linear Algebra"],
    ["94", "Art History"],
    ["94", "Operating Systems"],
    ["17", "Software Design"],
    ["58", "Mechanics"],
    ["58", "Economics"],
    ["17", "Linear Algebra"],
    ["17", "Political Science"],
    ["94", "Economics"]
]

Sample Output (pseudocode, in any order)


find_pairs(student_course_pairs) =>
{
    [58, 17]: ["Software Design", "Linear Algebra"]
    [58, 94]: ["Economics"]
    [17, 94]: []
}

*/
import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class StudentCourse {
    public static void main(String[] args) {

        String[][] studentCoursePairs = {
                {"58", "Software Design"},
                {"58", "Linear Algebra"},
                {"94", "Art History"},
                {"94", "Operating Systems"},
                {"17", "Software Design"},
                {"58", "Mechanics"},
                {"58", "Economics"},
                {"17", "Linear Algebra"},
                {"17", "Political Science"},
                {"94", "Economics"}
        };
        System.out.println(findMapping(studentCoursePairs));

    } //main

    // SD - 58 , 17

    // 17 - > SD


    // 94 -> OS , AH , LA



    public static Map<ArrayList<Integer>, ArrayList<String>> findMapping(String[][] input){
        Map<ArrayList<Integer>, ArrayList<String>> result = new HashMap<>();
        Map<String, ArrayList<Integer>> courseMap = new HashMap<>();
        Map<Integer, ArrayList<String>> studentMap = new HashMap<>();

        for (String[] student : input){
            int studentId = Integer.parseInt(student[0]);
            String courseName = student[1];

            if (courseMap.get(courseName)!= null){
                courseMap.get(courseName).add(0,studentId);
            }else {
                courseMap.put(courseName,new ArrayList<>(Arrays.asList(studentId)));
            }// courseMap

            if (studentMap.get(studentId)!= null){
                studentMap.get(studentId).add(0,courseName);
            }else {
                studentMap.put(studentId, new ArrayList<>(Arrays.asList(courseName)));
            }
        }//for
            List<Integer> visited = new ArrayList<>();
            for (Map.Entry<Integer, ArrayList<String>> entry : studentMap.entrySet()){
                 int sudentId = entry.getKey();
                    visited.add(sudentId) ;
                  List<String> studentCourse = studentMap.get(sudentId);
                  for (Map.Entry<Integer, ArrayList<String>> entry1 : studentMap.entrySet()){
                      ArrayList<Integer> studentList = new ArrayList<>();
                      ArrayList<String> courseList = new ArrayList<>();
                      studentList.add(sudentId);
                     int pairStudent = entry1.getKey();
                     if ( !visited.contains(pairStudent)){
                         List<String> pairCourse = studentMap.get(pairStudent);
                         studentList.add(pairStudent);
                         for (String course : pairCourse){
                             if (studentCourse.contains(course)){
                                 courseList.add(course);
                             }
                         }
                     }
                      if (studentList.size()==2)
                      result.put(studentList,courseList);
                 }

                }// for


        return result;
    }// findMapping





}


