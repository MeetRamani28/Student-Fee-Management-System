package com.ramani.service;

public interface StudentService {
    void addStudent(int rollNo, String name, double totalFee);
    void payFee(int rollNo, double amount);
    void viewAllStudents();
}
