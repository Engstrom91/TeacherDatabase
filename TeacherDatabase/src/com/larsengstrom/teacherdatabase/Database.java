package com.larsengstrom.teacherdatabase;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.larsengstrom.teacherdatabase.ExperienceLevel.SENIOR;

public class Database {

    //We initiate the database by adding the teachers we want to store in it.
    public static List<Teacher> initDatabase() {
        return List.of(
                new Teacher("Eric Grunwell", 23, true, ExperienceLevel.JUNIOR),
                new Teacher("Riley Cook", 43, true, SENIOR),
                new Teacher("Helena Thompson", 57, true, SENIOR),
                new Teacher("John Keating", 44, true, ExperienceLevel.JUNIOR),
                new Teacher("Jim Fletcher", 29, false, ExperienceLevel.JUNIOR),
                new Teacher("Jasmine Malm", 27, true, SENIOR),
                new Teacher("Alina Howard", 50, true, SENIOR)
        );
    }

    //We use a stream to filter out all teachers that have an ExperienceLevel of JUNIOR, they are then collected into a list and stored in result.
    public void filterTeachers(List<Teacher> list) {
        List<Teacher> result = list.stream()
                .filter(teacher -> teacher.getExperienceLevel().equals(ExperienceLevel.JUNIOR))
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    //We use a stream to compare the ages of all teachers, they get sorted from oldest to youngest and then collected into a list and stored in result.
    public void sortByAge(List<Teacher> list) {
    List<Teacher> result = list.stream()
            .sorted(Comparator.comparing(Teacher::getAge).reversed())
            .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    //Loops through all teachers and checks if the boolean certified is set to true.
    public void checkCertified(List<Teacher> list) {
        boolean allMatch = list.stream()
                .allMatch(teacher -> teacher.isCertified() == true);
        System.out.println("All teachers are certified: " + allMatch);
    }

    //Loops through all teachers and checks if one of them has an ExperienceLevel of SENIOR.
    public void anyMatchSenior(List<Teacher> list){
        boolean anyMatch = list.stream()
                .anyMatch(teacher -> teacher.getExperienceLevel() == SENIOR);
        System.out.println("A senior teacher has been employed: " + anyMatch);
    }

    //A stream is used to collect all teachers into groups based on their ExperienceLevel. The groups are then printed out separately.
    public void groupTeachers(List<Teacher> list){
        Map<ExperienceLevel, List<Teacher>> groupByExperienceLevel = list.stream()
                .collect(Collectors.groupingBy(Teacher::getExperienceLevel));
        groupByExperienceLevel.forEach((level, group) -> {
            System.out.println(level);
            group.forEach(System.out::println);
    });
    }
    /*This method takes a String as an argument,
    it then filters out the teachers whose names match the given String and collects them in a list. The list is then stored in matches. */
    public void searchByName(List<Teacher> list, String name){
            List<Teacher> matches = list.stream()
                    .filter(teacher -> teacher.getName().equals(name))
                    .collect(Collectors.toList());
            System.out.println(matches);
    }

}

