package com.bbva.student;

import java.util.List;

final class Student {

    private final String name;
    private final List<Course> courses;

    Student(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
