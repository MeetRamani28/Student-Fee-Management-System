package com.ramani.service;

import com.ramani.model.Student;
import com.ramani.repository.StudentRepository;

public class StudentServiceImpl implements StudentService{
    private final StudentRepository repository = new StudentRepository();

    @Override
    public void addStudent(int rollNo, String name, double totalFee) {
        if (repository.findByRollNo(rollNo) != null) {
            System.out.println("❌ Student already exists with roll no: " + rollNo);
            return;
        }

        if (totalFee <= 0) {
            System.out.println("❌ Total fee must be greater than zero");
            return;
        }

        Student student = new Student(rollNo, name, totalFee);
        repository.addStudent(student);
        System.out.println("✅ Student added successfully");
    }

    @Override
    public void payFee(int rollNo, double amount) {
        Student student = repository.findByRollNo(rollNo);

        if(student == null){
            System.out.println("❌ Student not found");
            return;
        }

        if (amount <= 0) {
            System.out.println("❌ Invalid payment amount");
            return;
        }

        double remainingFee = student.getRemainingFee();

        if (remainingFee <= 0) {
            System.out.println("ℹ Fee already fully paid");
            return;
        }

        if (amount > remainingFee) {
            System.out.println("❌ Payment exceeds remaining fee");
            System.out.println("Remaining fee: " + remainingFee);
            return;
        }

        student.payFee(amount);
        System.out.println("✅ Fee payment successful");
        System.out.println("Remaining fee: " + student.getRemainingFee());
    }

    @Override
    public void viewAllStudents() {
        if (repository.getAllStudents().isEmpty()) {
            System.out.println("⚠ No students found");
            return;
        }

        repository.getAllStudents().forEach(System.out::println);
    }
}
