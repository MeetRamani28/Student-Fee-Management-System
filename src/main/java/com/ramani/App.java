package com.ramani;

import com.ramani.service.StudentService;
import com.ramani.service.StudentServiceImpl;
import com.ramani.utils.InputUtil;

public class App {

    public static void main(String[] args) {

        StudentService service = new StudentServiceImpl();

        while (true) {

            System.out.println("\n====================================");
            System.out.println("     STUDENT FEE MANAGEMENT SYSTEM   ");
            System.out.println("====================================");
            System.out.println("1. Add Student");
            System.out.println("2. Pay Fee");
            System.out.println("3. View All Students");
            System.out.println("4. Exit");
            System.out.println("------------------------------------");
            System.out.print("Enter your choice: ");

            int choice = InputUtil.getInt();
            System.out.println();

            switch (choice) {

                case 1 -> {
                    System.out.println("---- Add New Student ----");

                    System.out.print("Enter Roll Number : ");
                    int roll = InputUtil.getInt();

                    System.out.print("Enter Student Name : ");
                    String name = InputUtil.getString();

                    System.out.print("Enter Total Fee    : ");
                    double fee = InputUtil.getDouble();

                    service.addStudent(roll, name, fee);
                }

                case 2 -> {
                    System.out.println("---- Fee Payment ----");

                    System.out.print("Enter Roll Number : ");
                    int roll = InputUtil.getInt();

                    System.out.print("Enter Amount      : ");
                    double amount = InputUtil.getDouble();

                    service.payFee(roll, amount);
                }

                case 3 -> {
                    System.out.println("---- Student List ----");
                    service.viewAllStudents();
                }

                case 4 -> {
                    System.out.println("\nThank you for using Student Fee Management System 👋");
                    System.exit(0);
                }

                default -> {
                    System.out.println("❌ Invalid choice. Please select between 1 to 4.");
                }
            }
        }
    }
}
