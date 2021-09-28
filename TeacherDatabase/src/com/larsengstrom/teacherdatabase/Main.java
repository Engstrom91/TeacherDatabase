package com.larsengstrom.teacherdatabase;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database database = new Database();
        List<Teacher> teachers = Database.initDatabase();

            //This loop provides the user interface for this application.
            while(true) {
                System.out.println("\n Welcome to the teacher database. What would you like to do? \n(0) Show all junior teachers (1) Sort teachers by age (2) Check for uncertified teachers " +
                        "(3) Check that we have at least one senior teacher (4) Group teachers by experience level");
            int input = scanner.nextInt();
            switch (input) {
                case 0:
                    //Filter for junior teachers
                    database.filterTeachers(teachers);
                    break;

                case 1:
                    //Sort teachers by age
                    database.sortByAge(teachers);
                    break;

                case 2:
                    //Checks if all teachers in the database are certified
                    database.checkCertified(teachers);
                    break;


                case 3:
                    //Check that at least one teacher is senior.
                    database.anyMatchSenior(teachers);
                    break;

                case 4:
                    //Check that at least one teacher is senior.
                    database.groupTeachers(teachers);
                    break;


            }
        }

    }

}
