package com.bbva.student;

import java.util.List;
import java.util.logging.Logger;

public class Teacher {

    private static final Logger logger = Logger.getLogger(Teacher.class.getName());
    private List<Student> student;

    public void addACourseToANaiveStudent() {
        allMyStudents().get(0).getCourses().add(new Course("Project Management"));
        logger.info("Venga mi bono");
    }

    private List<Student> allMyStudents() {
        return student;
    }
}
