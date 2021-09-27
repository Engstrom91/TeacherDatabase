package com.larsengstrom.teacherdatabase;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.larsengstrom.teacherdatabase.ExperienceLevel.SENIOR;

public class Database {

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

    public void filterTeachers(List<Teacher> list) {
        List<Teacher> result = list.stream()
                .filter(teacher -> teacher.getExperienceLevel().equals(ExperienceLevel.JUNIOR))
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    public void sortByAge(List<Teacher> list) {
    List<Teacher> result = list.stream()
            .sorted(Comparator.comparing(Teacher::getAge).reversed())
            .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    //All match, checks if all items satisfy the condition. Are all teachers certified?
    public void checkCertified(List<Teacher> list) {
        boolean allMatch = list.stream()
                .allMatch(teacher -> teacher.isCertified() == true);
        System.out.println("All teachers are certified: " + allMatch);
    }

    public void anyMatchSenior(List<Teacher> list){
        boolean anyMatch = list.stream()
                .anyMatch(teacher -> teacher.getExperienceLevel() == SENIOR);
        System.out.println("A senior teacher has been employed: " + anyMatch);
    }

    public void groupTeachers(List<Teacher> list){
        Map<ExperienceLevel, List<Teacher>> groupByExperienceLevel = list.stream()
                .collect(Collectors.groupingBy(Teacher::getExperienceLevel));
        groupByExperienceLevel.forEach((level, group) -> {
            System.out.println(level);
            group.forEach(System.out::println);
    });
    }
    public void searchByName(List<Teacher> list, String name){
            List<Teacher> matches = list.stream()
                    .filter(teacher -> teacher.getName().equals(name))
                    .collect(Collectors.toList());
            System.out.println(matches);
    }

}

