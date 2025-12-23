package com.ramani.repository;

import com.ramani.model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student){
        students.add(student);
    }

    public List<Student> getAllStudents(){
        return students;
    }

    public Student findByRollNo(int roll){
        for(Student s : students){
            if(s.getRollNo() == roll){
                return s;
            }
        }
        return null;
    }
}
