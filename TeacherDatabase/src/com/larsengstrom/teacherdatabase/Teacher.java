package com.larsengstrom.teacherdatabase;

public class Teacher {
    private final String name;
    private final int age;
    private final boolean certified;
    private final ExperienceLevel experienceLevel;

    public Teacher(String name, int age, boolean certified, ExperienceLevel experienceLevel) {
        this.name = name;
        this.age = age;
        this.certified = certified;
        this.experienceLevel = experienceLevel;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ExperienceLevel getExperienceLevel() {
        return experienceLevel;
    }

    public boolean isCertified() {
        return certified;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", certified=" + certified +
                ", experienceLevel=" + experienceLevel +
                '}';
    }
}
